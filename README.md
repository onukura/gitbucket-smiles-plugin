# gitbucket-smiles-plugin

[![Build Status](https://travis-ci.org/onukura/gitbucket-smiles-plugin.svg?branch=master)](https://travis-ci.org/onukura/gitbucket-smiles-plugin)

A GitBucket plugin for rendering smiles file.  
Based on [smilesDrawer](https://doc.gdb.tools/smilesDrawer/).

## Screenshot

![screenshot](https://github.com/onukura/gitbucket-smiles-plugin/blob/assets/screenshot.png?raw=true)

## Install

1. Download *.jar from Releases.
2. Deploy it to `GITBUCKET_HOME/plugins`.
3. Restart GitBucket.

## Build from source

```sbt
sbt clean package
```

The built package is located at
`target/scala-2.13/gitbucket-smiles-plugin_2.13-{plugin-version}.jar`.

```sbt
sbt assembly
```

This makes the assembly package
`target/scala-2.13/gitbucket-smiles-plugin-{plugin-version}.jar`
for deployment.

## Version

Plugin version|GitBucket version
:---|:---
1.0.x |4.32.x -

## Reference

[Daniel Probst and Jean-Louis Reymond
Journal of Chemical Information and Modeling 2018 58 (1), 1-7
DOI: 10.1021/acs.jcim.7b00425](https://pubs.acs.org/doi/10.1021/acs.jcim.7b00425)
