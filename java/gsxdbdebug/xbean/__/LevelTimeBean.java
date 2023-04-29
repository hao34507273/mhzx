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
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class LevelTimeBean extends XBean implements xbean.LevelTimeBean
/*     */ {
/*     */   private int serverlevel;
/*     */   private long starttime;
/*     */   private long upgradetime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.serverlevel = 0;
/*  23 */     this.starttime = 0L;
/*  24 */     this.upgradetime = 0L;
/*     */   }
/*     */   
/*     */   LevelTimeBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.serverlevel = 0;
/*  31 */     this.starttime = 0L;
/*  32 */     this.upgradetime = 0L;
/*     */   }
/*     */   
/*     */   public LevelTimeBean()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LevelTimeBean(LevelTimeBean _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LevelTimeBean(xbean.LevelTimeBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof LevelTimeBean)) { assign((LevelTimeBean)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LevelTimeBean _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.serverlevel = _o_.serverlevel;
/*  58 */     this.starttime = _o_.starttime;
/*  59 */     this.upgradetime = _o_.upgradetime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.serverlevel = _o_.serverlevel;
/*  65 */     this.starttime = _o_.starttime;
/*  66 */     this.upgradetime = _o_.upgradetime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.serverlevel);
/*  74 */     _os_.marshal(this.starttime);
/*  75 */     _os_.marshal(this.upgradetime);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.serverlevel = _os_.unmarshal_int();
/*  84 */     this.starttime = _os_.unmarshal_long();
/*  85 */     this.upgradetime = _os_.unmarshal_long();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.serverlevel);
/*  95 */     _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(3, this.upgradetime);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.serverlevel);
/* 107 */       _output_.writeInt64(2, this.starttime);
/* 108 */       _output_.writeInt64(3, this.upgradetime);
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
/* 136 */           this.serverlevel = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.starttime = _input_.readInt64();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.upgradetime = _input_.readInt64();
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
/*     */   public xbean.LevelTimeBean copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new LevelTimeBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LevelTimeBean toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LevelTimeBean toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new LevelTimeBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LevelTimeBean toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LevelTimeBean toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getServerlevel()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.serverlevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStarttime()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getUpgradetime()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.upgradetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setServerlevel(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "serverlevel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new xdb.logs.LogInt(this, LevelTimeBean.this.serverlevel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             LevelTimeBean.this.serverlevel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.serverlevel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogLong(this, LevelTimeBean.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             LevelTimeBean.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpgradetime(long _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "upgradetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new xdb.logs.LogLong(this, LevelTimeBean.this.upgradetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             LevelTimeBean.this.upgradetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.upgradetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     LevelTimeBean _o_ = null;
/* 303 */     if ((_o1_ instanceof LevelTimeBean)) { _o_ = (LevelTimeBean)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.serverlevel != _o_.serverlevel) return false;
/* 307 */     if (this.starttime != _o_.starttime) return false;
/* 308 */     if (this.upgradetime != _o_.upgradetime) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.serverlevel;
/* 318 */     _h_ = (int)(_h_ + this.starttime);
/* 319 */     _h_ = (int)(_h_ + this.upgradetime);
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.serverlevel);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.starttime);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.upgradetime);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("serverlevel"));
/* 343 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 344 */     lb.add(new ListenableChanged().setVarName("upgradetime"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LevelTimeBean {
/*     */     private Const() {}
/*     */     
/*     */     LevelTimeBean nThis() {
/* 352 */       return LevelTimeBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelTimeBean copy()
/*     */     {
/* 364 */       return LevelTimeBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelTimeBean toData()
/*     */     {
/* 370 */       return LevelTimeBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LevelTimeBean toBean()
/*     */     {
/* 375 */       return LevelTimeBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelTimeBean toDataIf()
/*     */     {
/* 381 */       return LevelTimeBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LevelTimeBean toBeanIf()
/*     */     {
/* 386 */       return LevelTimeBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getServerlevel()
/*     */     {
/* 393 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 394 */       return LevelTimeBean.this.serverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 401 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 402 */       return LevelTimeBean.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpgradetime()
/*     */     {
/* 409 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 410 */       return LevelTimeBean.this.upgradetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setServerlevel(int _v_)
/*     */     {
/* 417 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 425 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpgradetime(long _v_)
/*     */     {
/* 433 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 440 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return LevelTimeBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return LevelTimeBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return LevelTimeBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return LevelTimeBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       LevelTimeBean.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 492 */       return LevelTimeBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return LevelTimeBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return LevelTimeBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return LevelTimeBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return LevelTimeBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return LevelTimeBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return LevelTimeBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LevelTimeBean
/*     */   {
/*     */     private int serverlevel;
/*     */     
/*     */     private long starttime;
/*     */     
/*     */     private long upgradetime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.serverlevel = 0;
/* 550 */       this.starttime = 0L;
/* 551 */       this.upgradetime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.LevelTimeBean _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof LevelTimeBean)) { assign((LevelTimeBean)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof LevelTimeBean.Const)) assign(((LevelTimeBean.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LevelTimeBean _o_) {
/* 564 */       this.serverlevel = _o_.serverlevel;
/* 565 */       this.starttime = _o_.starttime;
/* 566 */       this.upgradetime = _o_.upgradetime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.serverlevel = _o_.serverlevel;
/* 572 */       this.starttime = _o_.starttime;
/* 573 */       this.upgradetime = _o_.upgradetime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.serverlevel);
/* 580 */       _os_.marshal(this.starttime);
/* 581 */       _os_.marshal(this.upgradetime);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.serverlevel = _os_.unmarshal_int();
/* 589 */       this.starttime = _os_.unmarshal_long();
/* 590 */       this.upgradetime = _os_.unmarshal_long();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.serverlevel);
/* 599 */       _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/* 600 */       _size_ += CodedOutputStream.computeInt64Size(3, this.upgradetime);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.serverlevel);
/* 610 */         _output_.writeInt64(2, this.starttime);
/* 611 */         _output_.writeInt64(3, this.upgradetime);
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
/* 638 */             this.serverlevel = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.starttime = _input_.readInt64();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.upgradetime = _input_.readInt64();
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
/*     */     public xbean.LevelTimeBean copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelTimeBean toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LevelTimeBean toBean()
/*     */     {
/* 687 */       return new LevelTimeBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LevelTimeBean toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LevelTimeBean toBeanIf()
/*     */     {
/* 698 */       return new LevelTimeBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
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
/*     */     public Bean toConst() {
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
/*     */     public int getServerlevel()
/*     */     {
/* 735 */       return this.serverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 742 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpgradetime()
/*     */     {
/* 749 */       return this.upgradetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setServerlevel(int _v_)
/*     */     {
/* 756 */       this.serverlevel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 763 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpgradetime(long _v_)
/*     */     {
/* 770 */       this.upgradetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.serverlevel != _o_.serverlevel) return false;
/* 779 */       if (this.starttime != _o_.starttime) return false;
/* 780 */       if (this.upgradetime != _o_.upgradetime) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.serverlevel;
/* 789 */       _h_ = (int)(_h_ + this.starttime);
/* 790 */       _h_ = (int)(_h_ + this.upgradetime);
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.serverlevel);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.starttime);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.upgradetime);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LevelTimeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */