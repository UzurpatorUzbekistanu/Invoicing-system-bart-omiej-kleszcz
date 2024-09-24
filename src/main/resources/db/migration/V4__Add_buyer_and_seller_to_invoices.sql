ALTER TABLE public.invoice
    ADD COLUMN seller bigint NOT NULL;

ALTER TABLE public.invoice
    ADD COLUMN buyer bigint NOT NULL;

ALTER TABLE public.invoice
    ADD CONSTRAINT buyer_fk FOREIGN KEY (buyer)
    REFERENCES public.companies (id);

ALTER TABLE public.invoice
    ADD CONSTRAINT seller_fK FOREIGN KEY (seller)
    REFERENCES public.companies (id);