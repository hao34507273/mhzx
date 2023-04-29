/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class SkillData extends XBean implements xbean.SkillData
/*     */ {
/*     */   private int useround;
/*     */   private int usecount;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.useround = 0;
/*  21 */     this.usecount = 0;
/*     */   }
/*     */   
/*     */   SkillData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.useround = 0;
/*  28 */     this.usecount = 0;
/*     */   }
/*     */   
/*     */   public SkillData()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SkillData(SkillData _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SkillData(xbean.SkillData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof SkillData)) { assign((SkillData)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SkillData _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.useround = _o_.useround;
/*  54 */     this.usecount = _o_.usecount;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.useround = _o_.useround;
/*  60 */     this.usecount = _o_.usecount;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.useround);
/*  68 */     _os_.marshal(this.usecount);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.useround = _os_.unmarshal_int();
/*  77 */     this.usecount = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt32Size(1, this.useround);
/*  87 */     _size_ += CodedOutputStream.computeInt32Size(2, this.usecount);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt32(1, this.useround);
/*  98 */       _output_.writeInt32(2, this.usecount);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 102 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 104 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       boolean done = false;
/* 114 */       while (!done)
/*     */       {
/* 116 */         int tag = _input_.readTag();
/* 117 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 121 */           done = true;
/* 122 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 126 */           this.useround = _input_.readInt32();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.usecount = _input_.readInt32();
/* 132 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 136 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 138 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 147 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillData copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new SkillData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillData toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillData toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new SkillData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillData toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillData toBeanIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUseround()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.useround;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUsecount()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.usecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUseround(int _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "useround")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new xdb.logs.LogInt(this, SkillData.this.useround)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             SkillData.this.useround = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.useround = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsecount(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "usecount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogInt(this, SkillData.this.usecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             SkillData.this.usecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.usecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     SkillData _o_ = null;
/* 259 */     if ((_o1_ instanceof SkillData)) { _o_ = (SkillData)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.useround != _o_.useround) return false;
/* 263 */     if (this.usecount != _o_.usecount) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ += this.useround;
/* 273 */     _h_ += this.usecount;
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.useround);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.usecount);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     ListenableBean lb = new ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("useround"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("usecount"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SkillData {
/*     */     private Const() {}
/*     */     
/*     */     SkillData nThis() {
/* 303 */       return SkillData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillData copy()
/*     */     {
/* 315 */       return SkillData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillData toData()
/*     */     {
/* 321 */       return SkillData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SkillData toBean()
/*     */     {
/* 326 */       return SkillData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillData toDataIf()
/*     */     {
/* 332 */       return SkillData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SkillData toBeanIf()
/*     */     {
/* 337 */       return SkillData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUseround()
/*     */     {
/* 344 */       SkillData.this._xdb_verify_unsafe_();
/* 345 */       return SkillData.this.useround;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUsecount()
/*     */     {
/* 352 */       SkillData.this._xdb_verify_unsafe_();
/* 353 */       return SkillData.this.usecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUseround(int _v_)
/*     */     {
/* 360 */       SkillData.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUsecount(int _v_)
/*     */     {
/* 368 */       SkillData.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       SkillData.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       SkillData.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return SkillData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return SkillData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       SkillData.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return SkillData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return SkillData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       SkillData.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return SkillData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return SkillData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return SkillData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return SkillData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return SkillData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return SkillData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return SkillData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SkillData
/*     */   {
/*     */     private int useround;
/*     */     
/*     */     private int usecount;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.useround = 0;
/* 483 */       this.usecount = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.SkillData _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof SkillData)) { assign((SkillData)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof SkillData.Const)) assign(((SkillData.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SkillData _o_) {
/* 496 */       this.useround = _o_.useround;
/* 497 */       this.usecount = _o_.usecount;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.useround = _o_.useround;
/* 503 */       this.usecount = _o_.usecount;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.useround);
/* 510 */       _os_.marshal(this.usecount);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.useround = _os_.unmarshal_int();
/* 518 */       this.usecount = _os_.unmarshal_int();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt32Size(1, this.useround);
/* 527 */       _size_ += CodedOutputStream.computeInt32Size(2, this.usecount);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt32(1, this.useround);
/* 537 */         _output_.writeInt32(2, this.usecount);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 551 */         boolean done = false;
/* 552 */         while (!done)
/*     */         {
/* 554 */           int tag = _input_.readTag();
/* 555 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 559 */             done = true;
/* 560 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 564 */             this.useround = _input_.readInt32();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.usecount = _input_.readInt32();
/* 570 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 574 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 576 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 585 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 589 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 591 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillData copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillData toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SkillData toBean()
/*     */     {
/* 608 */       return new SkillData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillData toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SkillData toBeanIf()
/*     */     {
/* 619 */       return new SkillData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 641 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 645 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 649 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUseround()
/*     */     {
/* 656 */       return this.useround;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUsecount()
/*     */     {
/* 663 */       return this.usecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUseround(int _v_)
/*     */     {
/* 670 */       this.useround = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUsecount(int _v_)
/*     */     {
/* 677 */       this.usecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.useround != _o_.useround) return false;
/* 686 */       if (this.usecount != _o_.usecount) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ += this.useround;
/* 695 */       _h_ += this.usecount;
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.useround);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.usecount);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SkillData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */