# meta-custom

自定义层，用于扩展和定制 meta-bbb 层的配置。

## 使用说明

此层用于存放你的自定义配置、recipes 和 bbappend 文件。

### 目录结构

- `recipes-*/` - 存放自定义的 recipes 和 bbappend 文件
- `images/` - 存放自定义镜像定义
- `conf/` - 层配置文件

### 如何覆盖 meta-bbb 的配置

在 `recipes-*` 目录下创建对应的 `.bbappend` 文件来覆盖或扩展 meta-bbb 的配置。

例如，要覆盖 meta-bbb 中的某个 recipe，创建：
```
recipes-example/package-name/package-name_1.0.bbappend
```

### 优先级

此层的优先级设置为 17，高于 meta-bbb（优先级 16），因此你的自定义配置会优先使用。

