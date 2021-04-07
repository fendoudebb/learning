package org.example;

import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.Locale;

public class PhoneUtil {

    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    private static int countryCode = phoneNumberUtil.getCountryCodeForRegion(Locale.getDefault().getCountry());

    private static PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();

    private static PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

    /**
     * 根据国家代码和手机号判断手机号是否有效
     *
     * @param phoneNumber 手机号
     * @param countryCode 国家代码，中国为 86
     * @return 手机号是否有效
     */
    public static boolean checkPhoneNumber(String phoneNumber, String countryCode){
        int ccode = Integer.parseInt(countryCode);
        long phone = Long.parseLong(phoneNumber);

        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(ccode);
        pn.setNationalNumber(phone);

        return phoneNumberUtil.isValidNumber(pn);

    }

    /**
     * 根据国家代码和手机号  判断手机运营商
     *
     * @param phoneNumber 手机号
     * @param countryCode 国家代码，中国为 86
     * @return 获取手机运营商
     */
    public static String getCarrier(String phoneNumber, String countryCode){

        int ccode = Integer.parseInt(countryCode);
        long phone = Long.parseLong(phoneNumber);

        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(ccode);
        pn.setNationalNumber(phone);

        PhoneNumberUtil.PhoneNumberType numberType = phoneNumberUtil.getNumberType(pn);

        //返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(pn, Locale.ENGLISH);
        String carrierZh = "";
        carrierZh += geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
        switch (carrierEn) {
        case "China Mobile":
            carrierZh += "移动";
            break;
        case "China Unicom":
            carrierZh += "联通";
            break;
        case "China Telecom":
            carrierZh += "电信";
            break;
        default:
            break;
        }
        carrierZh += numberType.name();
        return carrierZh;
    }

    /**
     * 根据手机号获取手机归属地
     *
     * @param phoneNumber 手机号
     * @return 归属地
     */
    public static String getGeo(String phoneNumber){
        long phone = Long.parseLong(phoneNumber);
        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(countryCode);
        pn.setNationalNumber(phone);
        return geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
    }

    public static void main(String[] args) {
            System.out.println(PhoneUtil.checkPhoneNumber("159655555","86")); // false
            System.out.println(PhoneUtil.checkPhoneNumber("18601720000","86")); // true
            System.out.println(PhoneUtil.getCarrier("18601720000","86")); // 上海市联通MOBILE
            System.out.println(PhoneUtil.getGeo("18601720000")); // 上海市
    }

}