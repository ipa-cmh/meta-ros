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
LIC_FILES_CHKSUM = "[path to license]; beginline=[first license line];endline=[last license line];md5=[md5 checksum]"
```




