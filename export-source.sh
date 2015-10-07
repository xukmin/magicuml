#!/bin/bash
git archive \
    --format=zip \
    --prefix=uml/ \
    --output=../uml-source-MinXu-$(date +"%Y-%m-%d-%H-%M").zip HEAD .
