package io.gitlab.arturbosch.detekt.ktlint

import io.gitlab.arturbosch.detekt.test.TestConfig
import io.gitlab.arturbosch.detekt.test.lint
import org.junit.jupiter.api.Test

/**
 * @author Artur Bosch
 */
internal class UnusedImportTest {

	@Test
	fun test() {
		val lint = UnusedImport(TestConfig(emptyMap())).lint("/home/artur/Repos/detekt/ktlint-over-detekt/src/main/kotlin/io/gitlab/arturbosch/detekt/ktlint/UnusedImport.kt")
		println(lint)
	}
}
