SUMMARY = "A command-line system information tool"
HOMEPAGE = "https://github.com/dylanaraps/neofetch"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=d300b86297c170b6498705fbb6794e3f"

SRC_URI = "git://github.com/dylanaraps/neofetch.git;protocol=https;branch=master;tag=${PV}"
SRCREV = "60d07dee6b76769d8c487a40639fb7b5a1a7bc85"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/neofetch ${D}${bindir}/neofetch
}

RDEPENDS:${PN} = "bash"

