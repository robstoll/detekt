package io.gitlab.arturbosch.detekt.ktlint

import org.jetbrains.kotlin.com.intellij.lang.ASTNode

/**
 * @author Artur Bosch
 */
internal fun ASTNode.visitTokens(currentNode: (node: ASTNode) -> Unit) {
	currentNode(this)
	getChildren(null).forEach { it.visitTokens(currentNode) }
}
