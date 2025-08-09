package fetal.percentiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PercentilesController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("percentileForm", new PercentileForm());
        return "form";
    }

    @PostMapping("/percentiles")
    public String calculate(@ModelAttribute PercentileForm percentileForm, Model model) {
        double ma = PercentileCalculator.menstrualAge(percentileForm.getWeeks(), percentileForm.getDays());
        double bpdPct = PercentileCalculator.bpdPercentile(ma, percentileForm.getBpd());
        double hcPct = PercentileCalculator.hcPercentile(ma, percentileForm.getHc());
        double acPct = PercentileCalculator.acPercentile(ma, percentileForm.getAc());
        double flPct = PercentileCalculator.flPercentile(ma, percentileForm.getFl());

        model.addAttribute("form", percentileForm);
        model.addAttribute("bpdPct", bpdPct);
        model.addAttribute("hcPct", hcPct);
        model.addAttribute("acPct", acPct);
        model.addAttribute("flPct", flPct);

        return "result";
    }
}

