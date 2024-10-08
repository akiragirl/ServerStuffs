# About
I made this plugin to help server owners who give players creative mode. However, I plan to add other features as well, hence the generic name.
This plugin is a huge work in progress. It may stay this way for a while because I'm 15 and don't have much time to work on it.

# How to use
The plugin should create a config.yml located at /plugins/ServerStuffs/config.yml.

In the config, there are flags. These flags dictate whether or not it should stop someone from getting certain items from the creative inventory (or pick block) with potentially dangerous custom data.

Each flag is briefly described, but I'll go over them anyway. Please note that items are affected even if the player already had that item; moving it around in the creative inventory might cause the item to be flagged. Clearing the item meta does not mean the item will disappear, but all associated data will be removed (such as its name, enchantments, etc).

`lazy`: Clears item meta from ALL items obtained from the creative inventory. This will break some items, such as paintings that specify their motif, and probably more.<br>
`block-states`: Clears item meta from any item with a block state. This includes containers.<br>
`spawn-eggs`: Clears item meta from spawn eggs that appear to modify the entity it's supposed to spawn. It will also clear the meta of a spawn egg if its name appears to be invalid.<br>
`spawners`: Clears item meta from mob spawners (such as the entity inside).<br>
`minecarts`: Clears item meta from minecarts (such as regular ones, chest ones, etc).<br>
`enchantments`: Clears item meta from items that appear to have invalid enchantments (enchantments with values over their maximum value; it does not check if an enchantment doesn't actually apply to that item yet).<br>
`books`: Clears item meta from written/writable books.<br>

## Bypass
To allow a normal player to bypass a setting, they must be granted the permission `serverstuffs.bypass.creative.(flag name)`. For instance, to allow a player to use custom spawn eggs, you would grant them the following permission: `serverstuffs.bypass.creative.spawn-eggs`.
