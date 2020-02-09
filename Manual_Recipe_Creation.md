# Manual recipe creation for ROS

## Inherits
The recipe is created for a ros package of a ros_distro (melodic|eloquent|...). Therefore, we need to inherit the rules to build ros packages (ros_component) and the ros distro.

```shell
# 
# Copyright (c) 2020 notice

inherit ros_distro_[ros_distro]
inherit ros_component
```

## Header
The header consists of the `DESCRIPTION` which is the `<description>`-tag of package.xml. In the same way, `AUTHOR`, `LICENSE` and `HOMEPAGE` can be directly copied from package.xml. When copying the license from package.xml remove all spaces as bitbake takes licenses in a space seperated manner. `SECTION` indicates the type of the package, we suggest indicating `devel`. 

```shell
DESCRIPTION = "<description>"
AUTHOR = "<author>"
ROS_AUTHOR = "<author>"
HOMEPAGE = "<url>"
SECTION = "[section]"
LICENSE = "<license>"
LIC_FILES_CHKSUM = "[path to license]; (optional: beginline=[first license line];endline=[last license line]);md5=[md5 checksum]"
```

Generate md5 for LICENSE file or part of a complete file:
```shell
cat [file] | md5sum
```

Generate md5 for a range of lines:
```shell
sed -n '[beginline],[endline]p' [file]
```

Generate md5 for a single line:
```shell
sed -n '[line]p' [file]
```

## ROS Variables

Indicate meta-package and package. If no meta-package available both are the same.
```shell
ROS_CN = "[meta-package name]"
ROS_BPN = "[package name]"
```

Example:
```shell
ROS_CN = "universal_robot"
ROS_BPN = "ur_msgs"
```

Indicate dependencies:
```shell
ROS_BUILD_DEPENDS = ""
ROS_BUILDTOOL_DEPENDS = ""
ROS_EXPORT_DEPENDS = ""
ROS_BUILDTOOL_EXPORT_DEPENDS = ""
ROS_EXEC_DEPENDS = ""
```
These can be extracted from the package.xml file.
`ROS_BUILDTOOL_DEPENDS` is typically `catkin-native`. Lines need to be ended with `\`. There is a bug with msgs-packages therefore in these packages `${PYTHON_PN}-pyyaml-native` needs to be added too.

`ROS_BUILD_DEPENDS` contains what is marked in package.xml as `<depend>` and `<build depend>`. Underscores in package.xml become dash in *.bb files.

`ROS_EXPORT_DEPENDS`contains what is marked in package.xml as `<export>`.

`ROS_BUILD_TOOL_EXPORT_DEPENDS`contains what is marked in package.xml as `<depend>`?

`ROS_EXEC_DEPENDS`contains what is marked in package.xml as `<run depend>`.

## Source Files

Indicate the source files.
```shell
SRC_URI = "git://github.com/[user]/[repository];branch=[branch];protocol=https"
SRCREV = "[commit]"
```

`SRC_URI` contains the repo uri, branch and the used protocol.

`SRCREV` contains the commit to be used to build the packages.

## Put it all together

```bb
# Copyright notice

inherit ros_distro_melodic
inherit ros_component

DESCRIPTION = "<description>"
AUTHOR = "<author>"
ROS_AUTHOR = "<author>"
HOMEPAGE = "<url>"
SECTION = "[section]"
LICENSE = "<license>"
LIC_FILES_CHKSUM = "[path to license]; (optional: beginline=[first license line];endline=[last license line]);md5=[md5 checksum]"

ROS_CN = "[meta-package name]"
ROS_BPN = "[package name]"

ROS_BUILD_DEPENDS = ""
ROS_BUILDTOOL_DEPENDS = ""
ROS_EXPORT_DEPENDS = ""
ROS_BUILDTOOL_EXPORT_DEPENDS = ""
ROS_EXEC_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"


SRC_URI = "git://github.com/[user]/[repository];branch=[branch];protocol=https"
SRCREV = "[commit]"


S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}

```
