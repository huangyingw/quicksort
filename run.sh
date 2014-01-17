#! /bin/bash
ant > result.cc 2>&1 \
  && ~/gitrc/gci.sh
