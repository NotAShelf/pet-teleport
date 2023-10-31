<h1 align="center">🐾 pet-teleport</h1>

<div align="center">
  <img src="https://i.imgur.com/Bwili3Z.png">
</div>

<div align="center">
  <code><img title="License" href="LICENSE" src="https://img.shields.io/github/license/NotAShelf/pet-teleport?style=flat-square"></code>
  <code><img title="Issues" href="https://github.com/NotAShelf/pet-teleport/issues" src="https://img.shields.io/github/issues/NotAShelf/pet-teleport?style=flat-square"></code>
  <code><img title="Maven Release CI" href="https://github.com/NotAShelf/pet-teleport/actions/workflows/preview.yml" src="https://github.com/NotAShelf/pet-teleport/actions/workflows/preview.yml/badge.svg"></code>
</div>

Ever teleported somewhere in Minecraft only for your pets to not follow you? I have! The problem is that the server instantly unloads unoccupied chunks, often with
your pet in stow! This plugin ensures that all standing pets teleport to you if they ever end up in an unloaded chunk. Handy!

## Usage

<div align="center">
  <a><img src="https://i.imgur.com/nbE7F5i.gif"></a>
  <br/>
</div>
<br>

Tame your desired pets and the plugin will automatically work when you teleport. There is practically no manual input from the player required.
Other than, well, moving around with your pets.

### Commands

None!

### Permissions

None!

### Configuration

```yaml
logPetTeleports: true

worldList:
  - lobby
  - hub
  - some_other_world

isBlacklist: true
```

| Option          | Description                                                                                                           | Type      |
| --------------- | --------------------------------------------------------------------------------------------------------------------- | --------- |
| logPetTeleports | Whether to log pet teleports in the server console                                                                    | `boolean` |
| worldList       | A list of worlds that pets may or may not teleport to                                                                 | `list`    |
| isBlacklist     | Whether the `worldList` option will act as a blacklist. <br>If false, pets may only teleport to the world in the list | `bool`    |

## License

This is a fork of [Chailotl's pet-teleport plugin](https://github.com/Chailotl/pet-teleport) with minor tweaks and updates. Following the
original license, this repository is also licensed with the [GPL-3.0 license](LICENSE).
