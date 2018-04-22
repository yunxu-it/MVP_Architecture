package cn.winxo.toolbox.data.entity.local;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class User {
    private int id;
    private String name;
    private String desc;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public User setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
