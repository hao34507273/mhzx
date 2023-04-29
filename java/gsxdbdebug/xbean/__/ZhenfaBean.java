/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class ZhenfaBean extends XBean implements xbean.ZhenfaBean
/*     */ {
/*     */   private int zhenfaid;
/*     */   private int zhenfalevel;
/*     */   private int zhenfaexp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.zhenfaid = 0;
/*  23 */     this.zhenfalevel = 0;
/*  24 */     this.zhenfaexp = 0;
/*     */   }
/*     */   
/*     */   ZhenfaBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.zhenfaid = 0;
/*  31 */     this.zhenfalevel = 0;
/*  32 */     this.zhenfaexp = 0;
/*     */   }
/*     */   
/*     */   public ZhenfaBean()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ZhenfaBean(ZhenfaBean _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ZhenfaBean(xbean.ZhenfaBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ZhenfaBean)) { assign((ZhenfaBean)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ZhenfaBean _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.zhenfaid = _o_.zhenfaid;
/*  58 */     this.zhenfalevel = _o_.zhenfalevel;
/*  59 */     this.zhenfaexp = _o_.zhenfaexp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.zhenfaid = _o_.zhenfaid;
/*  65 */     this.zhenfalevel = _o_.zhenfalevel;
/*  66 */     this.zhenfaexp = _o_.zhenfaexp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.zhenfaid);
/*  74 */     _os_.marshal(this.zhenfalevel);
/*  75 */     _os_.marshal(this.zhenfaexp);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.zhenfaid = _os_.unmarshal_int();
/*  84 */     this.zhenfalevel = _os_.unmarshal_int();
/*  85 */     this.zhenfaexp = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.zhenfaid);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.zhenfalevel);
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(3, this.zhenfaexp);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.zhenfaid);
/* 107 */       _output_.writeInt32(2, this.zhenfalevel);
/* 108 */       _output_.writeInt32(3, this.zhenfaexp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 112 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 114 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       boolean done = false;
/* 124 */       while (!done)
/*     */       {
/* 126 */         int tag = _input_.readTag();
/* 127 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 131 */           done = true;
/* 132 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 136 */           this.zhenfaid = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.zhenfalevel = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.zhenfaexp = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 151 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 153 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 162 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 166 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 168 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZhenfaBean copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new ZhenfaBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZhenfaBean toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZhenfaBean toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new ZhenfaBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZhenfaBean toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZhenfaBean toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZhenfaid()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.zhenfaid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZhenfalevel()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.zhenfalevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZhenfaexp()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.zhenfaexp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZhenfaid(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "zhenfaid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogInt(this, ZhenfaBean.this.zhenfaid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             ZhenfaBean.this.zhenfaid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.zhenfaid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZhenfalevel(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "zhenfalevel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogInt(this, ZhenfaBean.this.zhenfalevel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             ZhenfaBean.this.zhenfalevel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.zhenfalevel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZhenfaexp(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "zhenfaexp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogInt(this, ZhenfaBean.this.zhenfaexp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             ZhenfaBean.this.zhenfaexp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.zhenfaexp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     ZhenfaBean _o_ = null;
/* 303 */     if ((_o1_ instanceof ZhenfaBean)) { _o_ = (ZhenfaBean)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.zhenfaid != _o_.zhenfaid) return false;
/* 307 */     if (this.zhenfalevel != _o_.zhenfalevel) return false;
/* 308 */     if (this.zhenfaexp != _o_.zhenfaexp) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.zhenfaid;
/* 318 */     _h_ += this.zhenfalevel;
/* 319 */     _h_ += this.zhenfaexp;
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.zhenfaid);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.zhenfalevel);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.zhenfaexp);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("zhenfaid"));
/* 343 */     lb.add(new ListenableChanged().setVarName("zhenfalevel"));
/* 344 */     lb.add(new ListenableChanged().setVarName("zhenfaexp"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ZhenfaBean {
/*     */     private Const() {}
/*     */     
/*     */     ZhenfaBean nThis() {
/* 352 */       return ZhenfaBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenfaBean copy()
/*     */     {
/* 364 */       return ZhenfaBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenfaBean toData()
/*     */     {
/* 370 */       return ZhenfaBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ZhenfaBean toBean()
/*     */     {
/* 375 */       return ZhenfaBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenfaBean toDataIf()
/*     */     {
/* 381 */       return ZhenfaBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ZhenfaBean toBeanIf()
/*     */     {
/* 386 */       return ZhenfaBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfaid()
/*     */     {
/* 393 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 394 */       return ZhenfaBean.this.zhenfaid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfalevel()
/*     */     {
/* 401 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 402 */       return ZhenfaBean.this.zhenfalevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfaexp()
/*     */     {
/* 409 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 410 */       return ZhenfaBean.this.zhenfaexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfaid(int _v_)
/*     */     {
/* 417 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfalevel(int _v_)
/*     */     {
/* 425 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfaexp(int _v_)
/*     */     {
/* 433 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return ZhenfaBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return ZhenfaBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return ZhenfaBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return ZhenfaBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       ZhenfaBean.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return ZhenfaBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return ZhenfaBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return ZhenfaBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return ZhenfaBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return ZhenfaBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return ZhenfaBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return ZhenfaBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ZhenfaBean
/*     */   {
/*     */     private int zhenfaid;
/*     */     
/*     */     private int zhenfalevel;
/*     */     
/*     */     private int zhenfaexp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.zhenfaid = 0;
/* 550 */       this.zhenfalevel = 0;
/* 551 */       this.zhenfaexp = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.ZhenfaBean _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof ZhenfaBean)) { assign((ZhenfaBean)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof ZhenfaBean.Const)) assign(((ZhenfaBean.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ZhenfaBean _o_) {
/* 564 */       this.zhenfaid = _o_.zhenfaid;
/* 565 */       this.zhenfalevel = _o_.zhenfalevel;
/* 566 */       this.zhenfaexp = _o_.zhenfaexp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.zhenfaid = _o_.zhenfaid;
/* 572 */       this.zhenfalevel = _o_.zhenfalevel;
/* 573 */       this.zhenfaexp = _o_.zhenfaexp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.zhenfaid);
/* 580 */       _os_.marshal(this.zhenfalevel);
/* 581 */       _os_.marshal(this.zhenfaexp);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.zhenfaid = _os_.unmarshal_int();
/* 589 */       this.zhenfalevel = _os_.unmarshal_int();
/* 590 */       this.zhenfaexp = _os_.unmarshal_int();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.zhenfaid);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.zhenfalevel);
/* 600 */       _size_ += CodedOutputStream.computeInt32Size(3, this.zhenfaexp);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.zhenfaid);
/* 610 */         _output_.writeInt32(2, this.zhenfalevel);
/* 611 */         _output_.writeInt32(3, this.zhenfaexp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 615 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 617 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 625 */         boolean done = false;
/* 626 */         while (!done)
/*     */         {
/* 628 */           int tag = _input_.readTag();
/* 629 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 633 */             done = true;
/* 634 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 638 */             this.zhenfaid = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.zhenfalevel = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.zhenfaexp = _input_.readInt32();
/* 649 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 653 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 655 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 664 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenfaBean copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenfaBean toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ZhenfaBean toBean()
/*     */     {
/* 687 */       return new ZhenfaBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZhenfaBean toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ZhenfaBean toBeanIf()
/*     */     {
/* 698 */       return new ZhenfaBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 720 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfaid()
/*     */     {
/* 735 */       return this.zhenfaid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfalevel()
/*     */     {
/* 742 */       return this.zhenfalevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfaexp()
/*     */     {
/* 749 */       return this.zhenfaexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfaid(int _v_)
/*     */     {
/* 756 */       this.zhenfaid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfalevel(int _v_)
/*     */     {
/* 763 */       this.zhenfalevel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfaexp(int _v_)
/*     */     {
/* 770 */       this.zhenfaexp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 779 */       if (this.zhenfalevel != _o_.zhenfalevel) return false;
/* 780 */       if (this.zhenfaexp != _o_.zhenfaexp) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.zhenfaid;
/* 789 */       _h_ += this.zhenfalevel;
/* 790 */       _h_ += this.zhenfaexp;
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.zhenfaid);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.zhenfalevel);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.zhenfaexp);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ZhenfaBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */