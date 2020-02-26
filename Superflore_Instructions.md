# Superflore experimentation


## Setup superflore

Install git to clone repositories from github.

```sh
sudo apt install python3
sudo apt install git
sudo apt install docker.io
sudo apt install curl
```
Set git details:
```sh
git config --global user.name "[name]"
git config --global user.email "[mail]"
```


Clone the superflore repository from github.
```sh
git clone https://github.com/ros-infrastructure/superflore.git
```

Install requirements.txt from superflore repository.

```sh
cd superflore
pip3 install -r requirements.txt
```

Install and setup superflore.

```sh
sudo python3 ./setup.py install
```

## Setup ros
Install and setup ROS melodic (or follow [this](http://wiki.ros.org/Installation/Ubuntu)).

```sh
sudo sh -c 'echo "deb http://packages.ros.org/ros/ubuntu $(lsb_release -sc) main" > /etc/apt/sources.list.d/ros-latest.list'

sudo apt-key adv --keyserver 'hkp://keyserver.ubuntu.com:80' --recv-key C1CF6E31E6BADE8868B172B4F42ED6FBAB17C654

curl -sSL 'http://keyserver.ubuntu.com/pks/lookup?op=get&search=0xC1CF6E31E6BADE8868B172B4F42ED6FBAB17C654' | sudo apt-key add -

sudo apt update

sudo apt install ros-melodic-desktop-full
```

## Setup rosdep and rosdistro

```sh
sudo rosdep init
rosdep update
```

Clone [rosdistro](https://github.com/ros/rosdistro.git) into a local `rosdistro` directory.
```sh
git clone https://github.com/ros/rosdistro.git
```

Edit `rosdep` sources list to point to local rosdistro.

```sh
sudo gedit /etc/ros/rosdep/sources.list.d/20-default.list
```
20-default.list:
>yaml file//[/local path to rosdistro]/rosdistro/rosdep/base.yaml
>
>yaml file://[/local path to rosdistro]/rosdistro/rosdep/python.yaml
>
>yaml file://[/local path to rosdistro]/rosdistro/rosdep/ruby.yaml


## Setup of meta-ros 
Install prerequisits for meta-ros build environment.

```sh
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
        build-essential chrpath socat cpio python python3-pip python3-pexpect \
        xz-utils debianutils iputils-ping \
        g++-multilib locales lsb-release python3-distutils time
        
sudo locale-gen en_US.utf8
```

Create a new folder for project.
```sh
mkdir [project-name]
cd [project name]
```

Setup `meta-ros`.

Clone and create folders
```sh
git clone -b build-draft --single-branch git@github.com:ros/meta-ros build
mkdir conf
ln -snf ../conf build/.
```

Next steps will clone the OpenEmbedded metadata layers and generate conf/bblayers.conf . Select a configuration based on the OE-Core DISTRO (ros1, ros2, or webos), the ROS distro (melodic, crystal or dashing), and the OE-Core release series (thud) that you wish to build:

**Distro:**
 * distro=ros1
 * distro=ros2
 * distro=webos

**ROS distro:**
 * ros_distro=melodic
 * ros_distro=crystal
 * ros_distro=dashing
 * ros_distro=eloquent

**Openembedded release:**
 * oe_release_series=thud


Note that final branches of meta-ros and meta-ros-webos for OE-Core release series "thud" are not yet available. Until they are, the .mcf files fetch rebaseable drafts of them.

Example for melodic:
```sh
distro=ros1
ros_distro=melodic
oe_release_series=thud
cfg=$distro-$ros_distro-$oe_release_series.mcf
cp build/files/$cfg conf/.
build/scripts/mcf -f conf/$cfg
```
Setup build environment.
```sh
unset BDIR BITBAKEDIR BUILDDIR OECORELAYERCONF OECORELOCALCONF OECORENOTESCONF OEROOT TEMPLATECONF
source openembedded-core/oe-init-build-env
cd ../meta-ros
```

## Generate recipes with superflore

First create a cache using the following command
```
sh scripts/ros-generate-cache.sh ROS_DISTRO RELEASE-YYYYMMDD PATH-TO-LOCAL-ROS-ROSDISTRO ROS-ROSDISTRO-COMMIT
```

Example:
```sh
sh scripts/ros-generate-cache.sh melodic 20180523 ~/rosdistro eb0f60951c4df8cb1aaf9b945539de5647428c38

```

The generate recipes:
```sh
sh scripts/ros-generate-recipes.sh melodic
```
