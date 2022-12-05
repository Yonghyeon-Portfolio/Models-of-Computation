# There is a child who likes all books that are not educational
∃x(C(x) ∧ ∀y(B(y)∧¬E(y)) → L(x, y))

# Prenex NF
∀x(R(x, y) ∧ ¬∀yR(x, y))
∀x(R(x, y) ∧ ¬∀zR(x, z)) # Q renaming
∀x(R(x, y) ∧ ∃z¬R(x, z)) # Q negation
∀x∃z(R(x, y) ∧ ¬R(x, z)) # Q extraction

(((∃xS(x) ∨ ∃xS(x)) ∨ ∃x¬S(x))∧(∃xS(x)→∀xS(x)))	
((∃xS(x) ∨ (∃xS(x) ∨ ∃x¬S(x)))∧(∃xS(x)→∀xS(x)))	
((∃xS(x) ∨ (∃xS(x) ∨ ∃x¬S(x)))∧(∃xS(x)→∀xS(x)))	
