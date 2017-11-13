package io.gitlab.arturbosch.detekt.ktlint

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

/**
 * @author Artur Bosch
 */
class KtLintProvider : RuleSetProvider {

	override val ruleSetId: String = "ktlint"

	override fun instance(config: Config) = RuleSet(ruleSetId,
			listOf(UnusedImport(config)))
}
