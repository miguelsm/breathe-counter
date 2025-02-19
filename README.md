# Breathe CLI

## Description

The **Breathe CLI** is a simple Node.js-based command-line tool written in `nbb` (Node Babashka) that guides users through a breathing exercise using voice prompts via `espeak`.

## Features

- Supports customizable breathing patterns.
- Uses `espeak` for voice-guided prompts.
- Provides countdown timing for breathing phases.
- Repeats the breathing cycle for a specified number of times.
- Ends the session with a "Well done!" voice prompt.

## Prerequisites

- If using Nix, run:

  ```sh
  nix develop
  ```

  This will open a shell with all necessary dependencies installed.

- Otherwise, install `espeak` manually:

  ```sh
  sudo apt install espeak
  ```

## Installation

Install dependencies with:

```sh
npm install
```

## Usage

You can run the CLI using either of the following methods:

Using `npx`:

```sh
npx nbb -m breathe <in-hold-out-hold> <cycles>
```

Using `npm run`:

```sh
npm run breathe -- <in-hold-out-hold> <cycles>
```

Example:

```sh
npx nbb -m breathe 4-1-2-1 30
```

or

```sh
npm run breathe -- 4-1-2-1 30
```

This means:

- Inhale for **4 seconds**
- Hold for **1 second**
- Exhale for **2 seconds**
- Hold for **1 second**
- Repeat **30 times**

## Example Output

```
Cycle 1/30
Breathe in for 4 seconds...
Hold for 1 second...
Breathe out for 2 seconds...
Hold for 1 second...
...
Well done!
```

## License

This project is released under the MIT License.
