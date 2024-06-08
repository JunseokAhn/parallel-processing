import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ExampleTest {

    ThreadExample threadExample = new ThreadExample();
    ExecutorServiceExample executorServiceExample= new ExecutorServiceExample();

    @Test
    void threadTest(){
        HashMap<String, Map<String, Integer>> run = threadExample.run();
        sysout(run);
        //Thread-1: http://example.org
        //단어 리스트: {=1, rgba=1, css=1, 02=1, fdfdff=1, shadow=1, illustrative=1, none=1, type=2, without=1, arial=1, text=3, href=1, https=1, decoration=1, you=1, margin=3, in=3, is=1, 0=8, 1=1, 600px=1, system=2, examples=1, meta=3, domain=4, 8=2, style=2, device=1, charset=2, example=3, literature=1, 2em=1, a=4, may=1, max=1, initial=1, more=1, segoe=1, doctype=1, p=4, helvetica=2, width=5, information=1, 3px=1, open=1, font=1, 7px=1, auto=3, blinkmacsystemfont=1, documents=1, use=2, body=3, coordination=1, div=4, ui=2, prior=1, www=1, html=4, radius=1, 5em=2, border=1, 700px=1, 38488f=1, utf=2, sans=2, this=2, domains=1, neue=1, background=2, name=1, http=1, 2px=2, f0f0f2=1, color=3, asking=1, link=1, for=2, scale=1, h1=2, box=1, media=1, title=2, content=3, head=2, apple=1, padding=2, or=1, org=1, permission=1, equiv=1, viewport=1, visited=1, serif=1, iana=1, family=1}
        //Thread-2: http://example.net
        //단어 리스트: {=1, rgba=1, css=1, 02=1, fdfdff=1, shadow=1, illustrative=1, none=1, type=2, without=1, arial=1, text=3, href=1, https=1, decoration=1, you=1, margin=3, in=3, is=1, 0=8, 1=1, 600px=1, system=2, examples=1, meta=3, domain=4, 8=2, style=2, device=1, charset=2, example=3, literature=1, 2em=1, a=4, may=1, max=1, initial=1, more=1, segoe=1, doctype=1, p=4, helvetica=2, width=5, information=1, 3px=1, open=1, font=1, 7px=1, auto=3, blinkmacsystemfont=1, documents=1, use=2, body=3, coordination=1, div=4, ui=2, prior=1, www=1, html=4, radius=1, 5em=2, border=1, 700px=1, 38488f=1, utf=2, sans=2, this=2, domains=1, neue=1, background=2, name=1, http=1, 2px=2, f0f0f2=1, color=3, asking=1, link=1, for=2, scale=1, h1=2, box=1, media=1, title=2, content=3, head=2, apple=1, padding=2, or=1, org=1, permission=1, equiv=1, viewport=1, visited=1, serif=1, iana=1, family=1}
        //Thread-0: http://example.com
        //단어 리스트: {=1, rgba=1, css=1, 02=1, fdfdff=1, shadow=1, illustrative=1, none=1, type=2, without=1, arial=1, text=3, href=1, https=1, decoration=1, you=1, margin=3, in=3, is=1, 0=8, 1=1, 600px=1, system=2, examples=1, meta=3, domain=4, 8=2, style=2, device=1, charset=2, example=3, literature=1, 2em=1, a=4, may=1, max=1, initial=1, more=1, segoe=1, doctype=1, p=4, helvetica=2, width=5, information=1, 3px=1, open=1, font=1, 7px=1, auto=3, blinkmacsystemfont=1, documents=1, use=2, body=3, coordination=1, div=4, ui=2, prior=1, www=1, html=4, radius=1, 5em=2, border=1, 700px=1, 38488f=1, utf=2, sans=2, this=2, domains=1, neue=1, background=2, name=1, http=1, 2px=2, f0f0f2=1, color=3, asking=1, link=1, for=2, scale=1, h1=2, box=1, media=1, title=2, content=3, head=2, apple=1, padding=2, or=1, org=1, permission=1, equiv=1, viewport=1, visited=1, serif=1, iana=1, family=1}
    }


    @Test
    void executorServiceTest(){
        HashMap<String, Map<String, Integer>> run = executorServiceExample.run();
        sysout(run);
        //pool-1-thread-1: http://example.com
        //단어 리스트: {=1, rgba=1, 02=1, auto=3, css=1, fdfdff=1, shadow=1, blinkmacsystemfont=1, documents=1, use=2, illustrative=1, none=1, body=3, type=2, without=1, coordination=1, arial=1, div=4, ui=2, prior=1, www=1, html=4, https=1, href=1, text=3, radius=1, decoration=1, 5em=2, you=1, border=1, 700px=1, margin=3, 38488f=1, in=3, sans=2, utf=2, this=2, domains=1, is=1, 0=8, 600px=1, 1=1, system=2, examples=1, neue=1, background=2, meta=3, domain=4, name=1, 8=2, http=1, 2px=2, style=2, device=1, f0f0f2=1, charset=2, color=3, asking=1, for=2, link=1, h1=2, scale=1, box=1, media=1, title=2, content=3, example=3, head=2, literature=1, apple=1, 2em=1, a=4, padding=2, or=1, may=1, org=1, max=1, initial=1, more=1, permission=1, segoe=1, p=4, doctype=1, equiv=1, viewport=1, helvetica=2, visited=1, width=5, serif=1, information=1, iana=1, 3px=1, family=1, open=1, 7px=1, font=1}
        //pool-1-thread-3: http://example.net
        //단어 리스트: {=1, rgba=1, 02=1, auto=3, css=1, fdfdff=1, shadow=1, blinkmacsystemfont=1, documents=1, use=2, illustrative=1, none=1, body=3, type=2, without=1, coordination=1, arial=1, div=4, ui=2, prior=1, www=1, html=4, https=1, href=1, text=3, radius=1, decoration=1, 5em=2, you=1, border=1, 700px=1, margin=3, 38488f=1, in=3, sans=2, utf=2, this=2, domains=1, is=1, 0=8, 600px=1, 1=1, system=2, examples=1, neue=1, background=2, meta=3, domain=4, name=1, 8=2, http=1, 2px=2, style=2, device=1, f0f0f2=1, charset=2, color=3, asking=1, for=2, link=1, h1=2, scale=1, box=1, media=1, title=2, content=3, example=3, head=2, literature=1, apple=1, 2em=1, a=4, padding=2, or=1, may=1, org=1, max=1, initial=1, more=1, permission=1, segoe=1, p=4, doctype=1, equiv=1, viewport=1, helvetica=2, visited=1, width=5, serif=1, information=1, iana=1, 3px=1, family=1, open=1, 7px=1, font=1}
        //pool-1-thread-2: http://example.org
        //단어 리스트: {=1, rgba=1, 02=1, auto=3, css=1, fdfdff=1, shadow=1, blinkmacsystemfont=1, documents=1, use=2, illustrative=1, none=1, body=3, type=2, without=1, coordination=1, arial=1, div=4, ui=2, prior=1, www=1, html=4, https=1, href=1, text=3, radius=1, decoration=1, 5em=2, you=1, border=1, 700px=1, margin=3, 38488f=1, in=3, sans=2, utf=2, this=2, domains=1, is=1, 0=8, 600px=1, 1=1, system=2, examples=1, neue=1, background=2, meta=3, domain=4, name=1, 8=2, http=1, 2px=2, style=2, device=1, f0f0f2=1, charset=2, color=3, asking=1, for=2, link=1, h1=2, scale=1, box=1, media=1, title=2, content=3, example=3, head=2, literature=1, apple=1, 2em=1, a=4, padding=2, or=1, may=1, org=1, max=1, initial=1, more=1, permission=1, segoe=1, p=4, doctype=1, equiv=1, viewport=1, helvetica=2, visited=1, width=5, serif=1, information=1, iana=1, 3px=1, family=1, open=1, 7px=1, font=1}
    }

    void sysout(HashMap<String, Map<String, Integer>> results){
        results.forEach((url, wordFrequency) -> {
            System.out.println(url);
            System.out.println("단어 리스트: " + wordFrequency);
        });

    }
}