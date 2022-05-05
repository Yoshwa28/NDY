package com.example.ndy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.Expression;


public class operacionesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;
    //Declarar variables
    TextView tvTrabajo, tvResultado;
    Button btnPI, btnPD, btnBorrar, btnLimpiar, siete, ocho, nueve, btnPorcentaje, btnRaiz, cuatro, cinco, seis, btnMultiplicacion, btnDivision, uno, dos, tres, btnSuma, btnResta, cero, btnPunto, btnIgual;


    public operacionesFragment() {
        // Required empty public constructor
    }

    public static operacionesFragment newInstance(String param1, String param2) {
        operacionesFragment fragment = new operacionesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_operaciones, container, false);
        //------------------------------------------------------------------------------------------
        tvTrabajo = (TextView)view.findViewById(R.id.tvTrabajo);
        tvResultado = (TextView)view.findViewById(R.id.tvResultado);

        btnPD = (Button)view.findViewById(R.id.btnPD);
        btnPI = (Button)view.findViewById(R.id.btnPI);
        btnLimpiar = (Button)view.findViewById(R.id.btnLimpiar);
        btnBorrar = (Button)view.findViewById(R.id.btnBorrar);

        btnRaiz = (Button)view.findViewById(R.id.btnRaiz);
        btnPorcentaje = (Button)view.findViewById(R.id.btnPorcentaje);
        btnMultiplicacion = (Button)view.findViewById(R.id.btnMultiplicacion);
        btnDivision = (Button)view.findViewById(R.id.btnDivision);
        btnSuma = (Button)view.findViewById(R.id.btnSuma);
        btnResta = (Button)view.findViewById(R.id.btnResta);
        btnIgual = (Button)view.findViewById(R.id.btnIgual);
        btnPunto = (Button)view.findViewById(R.id.btnPunto);

        cero = (Button)view.findViewById(R.id.cero);
        uno = (Button)view.findViewById(R.id.uno);
        dos = (Button)view.findViewById(R.id.dos);
        tres = (Button)view.findViewById(R.id.tres);
        cuatro = (Button)view.findViewById(R.id.cuatro);
        cinco = (Button)view.findViewById(R.id.cinco);
        seis = (Button)view.findViewById(R.id.seis);
        siete = (Button)view.findViewById(R.id.siete);
        ocho = (Button)view.findViewById(R.id.ocho);
        nueve = (Button)view.findViewById(R.id.nueve);
        //
        btnPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTrabajo.setText(String.format("%s)", tvTrabajo.getText()));
            }});

        btnPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTrabajo.setText(String.format("%s(", tvTrabajo.getText()));
            }});

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTrabajo.setText(""); tvResultado.setText("");
            }});

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvTrabajo.getText().toString().isEmpty()){
                    tvTrabajo.setText(tvTrabajo.getText().toString().substring(0, tvTrabajo.getText().toString().length()-1));
                }
        }});

        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "0");
        }});
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "1");
            }});
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "2");
            }});
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "3");
            }});
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "4");
            }});
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "5");
            }});
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "6");
            }});
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "7");
            }});
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "8");
            }});
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("number", "9");
            }});

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("operator", "%");
            }});
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("operator", "x");
            }});
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("operator", "÷");
            }});
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("operator", "+");
            }});
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("operator", "-");
            }});
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero("operator", ".");
            }});
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replacedString = tvTrabajo.getText().toString();
                replacedString = replacedString.replace('÷','/');
                replacedString = replacedString.replace('x','*');
                replacedString = replacedString.replace(',','.');
                replacedString = replacedString.replace("(","*(");
                Expression exp = new Expression(replacedString);
                tvResultado.setText(String.valueOf(exp.calculate()));
                numero("operator", "=");
        }});


        return view;
    }

    public void numero(String inType, String value){
        if (inType.equals("number")) {
            tvTrabajo.setText(String.format("%s%s", tvTrabajo.getText(), value));
        }
        else {
            if (!tvTrabajo.getText().toString().isEmpty()){
                String lc = tvTrabajo.getText().toString().substring(tvTrabajo.getText().toString().length() - 1);    // Ultimo caracter

                if (inType.equals("operator")){
                    if (lc.equals("0") || lc.equals("1") || lc.equals("2") || lc.equals("3") || lc.equals("4") || lc.equals("5") || lc.equals("6") || lc.equals("7") || lc.equals("8") || lc.equals("9")) {
                        tvTrabajo.setText(String.format("%s%s", tvTrabajo.getText(), value));
                    }
                }
            }
        }
    }
}