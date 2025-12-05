SUMMARY = "A minimal console image for SD card boot on AM3359 boards"

LICENSE = "MIT"

inherit core-image extrausers

# 最小系统核心组件
# core-image类会自动包含packagegroup-core-boot，这里只添加必要的额外组件
IMAGE_INSTALL = " \
    packagegroup-core-boot \
    kernel-modules \
    kernel-image \
    kernel-devicetree \
"

# 基本工具（core-image已包含base-files, base-passwd等基础包）
IMAGE_INSTALL += " \
    util-linux \
    util-linux-mount \
    util-linux-umount \
"

# SSH支持
IMAGE_INSTALL += " \
    packagegroup-core-ssh-openssh \
"

# 网络支持（包含ifconfig命令）
IMAGE_INSTALL += " \
    netbase \
    iproute2 \
    net-tools \
"

# htop系统监控工具
IMAGE_INSTALL += " \
    htop \
"

# neofetch系统信息工具
IMAGE_INSTALL += " \
    neofetch \
"

# Python3支持
IMAGE_INSTALL += " \
    python3 \
    python3-pip \
    python3-modules \
"

# ldconfig工具（动态链接库配置）
IMAGE_INSTALL += " \
    ldconfig \
"

# sudo和passwd命令
IMAGE_INSTALL += " \
    sudo \
    shadow \
"

# 时区设置
IMAGE_INSTALL += "tzdata"

# 设置root密码为"root"
# 密码哈希使用sha256crypt算法生成
ROOT_PASSWORD_HASH = "\$6\$EGCf7+R9\$vNHeKnD9PDPaKT0XlOjvE5Tai2e3W1Tanfie5uYILMyt7qUrwm2zbSOKXLTakhkJUnaHKSqBwqdx7IG03Mons."

EXTRA_USERS_PARAMS = " \
    usermod -p '${ROOT_PASSWORD_HASH}' root; \
"

# 设置本地时区
set_local_timezone() {
    ln -sf /usr/share/zoneinfo/UTC ${IMAGE_ROOTFS}/etc/localtime
    echo 'UTC' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

export IMAGE_BASENAME = "core-image-minimal-sdcard"

# 指定wic kickstart文件用于生成完整SD卡镜像
WKS_FILE = "am3359-sdcard.wks"

