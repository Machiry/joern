#!/bin/bash

BASEDIR=$(dirname "$0")

java -cp "$BASEDIR/projects/joern-php/build/libs/joern-php.jar:$BASEDIR/projects/jpanlib/build/libs/jpanlib.jar:$BASEDIR/jars/*" tools.php.ast2cfgddg.Main $@