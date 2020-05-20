#!/bin/bash

nim c -d:release src/Strategy-Card-Game-AI-Competition/referee-nim/Runner.nim
src/Strategy-Card-Game-AI-Competition/referee-nim/Runner \
  --p1-draft="java -cp 'out/production/LOCM-462-project' Main draft" \
  --p1-player="java -cp 'out/production/LOCM-462-project' Main play" \
  --p1-time=100 \
  --p2-draft=ClosetAI \
  --p2-player=FMC \
  --p2-time=150 \
  --games=1 \
  --verbose=true