package uml.association.duplex;

/**
 * association: 关联关系
 * 依赖关系的特例
 * 双向一对一关联
 * User关联IDCard，IDCard中同样关联User
 */
public class User {
    private IDCard idCard;
}
