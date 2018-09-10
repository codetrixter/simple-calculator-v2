package zurche.simplecalculator.calculator

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mCalculatorViewModel: CalculatorViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCalculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        mCalculatorViewModel!!.getInvalidExpressionMessageEvent().observe(this, Observer { shouldShow ->
            if (shouldShow != null && shouldShow) {
                Toast.makeText(this, getString(R.string.invalid_expression_message), Toast.LENGTH_SHORT).show()
            }
        })

        mCalculatorViewModel!!.getCurrentExpression().observe(this, Observer<String> { newOperation ->
            operation.text = newOperation
        })

        mCalculatorViewModel!!.getResult().observe(this, Observer<String> { result ->
            operation_result.text = result
        })

        zero.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.zero)) }
        one.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.one)) }
        two.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.two)) }
        three.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.three)) }
        four.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.four)) }
        five.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.five)) }
        six.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.six)) }
        seven.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.seven)) }
        eight.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.eight)) }
        nine.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.nine)) }

        ac.setOnClickListener { mCalculatorViewModel!!.onClearExpression() }
        plus_minus_switch.setOnClickListener { mCalculatorViewModel!!.onExpressionSignChange() }
        percentage.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.percentage)) }
        comma.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.comma_expression)) }
        equals.setOnClickListener { mCalculatorViewModel!!.onCalculateResult() }

        divide.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.divide_operator)) }
        multiply.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.multiply_expression)) }
        plus.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.plus)) }
        minus.setOnClickListener { mCalculatorViewModel!!.onOperatorAdd(getString(R.string.minus)) }
    }
}
