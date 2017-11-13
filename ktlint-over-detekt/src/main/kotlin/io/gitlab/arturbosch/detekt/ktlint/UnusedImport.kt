package io.gitlab.arturbosch.detekt.ktlint

import com.github.shyiko.ktlint.ruleset.standard.NoUnusedImportsRule
import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtFile

/**
 * @author Artur Bosch
 */
class UnusedImport(config: Config) : Rule(config) {

	override val issue = Issue(javaClass.simpleName, Severity.Style, "", Debt.FIVE_MINS)

	private val wrapper = NoUnusedImportsRule()

	override fun visit(root: KtFile) {
		root.node.visitTokens { node ->
			wrapper.visit(node, autoCorrect) { _, errorMessage, _ ->
				report(CodeSmell(issue, Entity.from(node.psi), errorMessage))
			}
		}
	}
}
