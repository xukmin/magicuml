#!/bin/bash
git archive \
    --format=zip \
    --prefix=magicuml/ \
    --output=../magicuml-source-$(date +"%Y-%m-%d-%H-%M").zip HEAD .
