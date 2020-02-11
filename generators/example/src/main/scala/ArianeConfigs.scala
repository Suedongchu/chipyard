package example

import chisel3._

import freechips.rocketchip.config.{Config}

// ---------------------
// Ariane Configs
// ---------------------

class ArianeConfig extends Config(
  new WithTSI ++                                           // use testchipip serial offchip link
  new WithNoGPIO ++
  new WithBootROM ++
  new WithUART ++
  new freechips.rocketchip.subsystem.WithNoMMIOPort ++     // no top-level MMIO master port (overrides default set in rocketchip)
  new freechips.rocketchip.subsystem.WithNoSlavePort ++    // no top-level MMIO slave port (overrides default set in rocketchip)
  new ariane.WithNArianeCores(1) ++                        // single Ariane core
  new freechips.rocketchip.system.BaseConfig)              // "base" rocketchip system

class dmiArianeConfig extends Config(
  new WithDTM ++                                           // use top with dtm
  new WithNoGPIO ++
  new WithBootROM ++
  new WithUART ++
  new freechips.rocketchip.subsystem.WithNoMMIOPort ++     // no top-level MMIO master port (overrides default set in rocketchip)
  new freechips.rocketchip.subsystem.WithNoSlavePort ++    // no top-level MMIO slave port (overrides default set in rocketchip)
  new ariane.WithNArianeCores(1) ++
  new freechips.rocketchip.system.BaseConfig)              // "base" rocketchip system
