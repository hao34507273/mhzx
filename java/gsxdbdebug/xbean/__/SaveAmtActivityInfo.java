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
/*     */ public final class SaveAmtActivityInfo extends XBean implements xbean.SaveAmtActivityInfo
/*     */ {
/*     */   private long save_amt;
/*     */   private int sortid;
/*     */   private boolean is_reset;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.save_amt = 0L;
/*  23 */     this.sortid = 0;
/*  24 */     this.is_reset = false;
/*     */   }
/*     */   
/*     */   SaveAmtActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.save_amt = 0L;
/*  31 */     this.is_reset = false;
/*     */   }
/*     */   
/*     */   public SaveAmtActivityInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SaveAmtActivityInfo(SaveAmtActivityInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SaveAmtActivityInfo(xbean.SaveAmtActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof SaveAmtActivityInfo)) { assign((SaveAmtActivityInfo)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SaveAmtActivityInfo _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.save_amt = _o_.save_amt;
/*  57 */     this.sortid = _o_.sortid;
/*  58 */     this.is_reset = _o_.is_reset;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.save_amt = _o_.save_amt;
/*  64 */     this.sortid = _o_.sortid;
/*  65 */     this.is_reset = _o_.is_reset;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _xdb_verify_unsafe_();
/*  72 */     _os_.marshal(this.save_amt);
/*  73 */     _os_.marshal(this.sortid);
/*  74 */     _os_.marshal(this.is_reset);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.save_amt = _os_.unmarshal_long();
/*  83 */     this.sortid = _os_.unmarshal_int();
/*  84 */     this.is_reset = _os_.unmarshal_boolean();
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     int _size_ = 0;
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(1, this.save_amt);
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(2, this.sortid);
/*  95 */     _size_ += CodedOutputStream.computeBoolSize(3, this.is_reset);
/*  96 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 102 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 105 */       _output_.writeInt64(1, this.save_amt);
/* 106 */       _output_.writeInt32(2, this.sortid);
/* 107 */       _output_.writeBool(3, this.is_reset);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 111 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 113 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       boolean done = false;
/* 123 */       while (!done)
/*     */       {
/* 125 */         int tag = _input_.readTag();
/* 126 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 130 */           done = true;
/* 131 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 135 */           this.save_amt = _input_.readInt64();
/* 136 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 140 */           this.sortid = _input_.readInt32();
/* 141 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 145 */           this.is_reset = _input_.readBool();
/* 146 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 150 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 152 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 161 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 165 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 167 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SaveAmtActivityInfo copy()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return new SaveAmtActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SaveAmtActivityInfo toData()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SaveAmtActivityInfo toBean()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new SaveAmtActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SaveAmtActivityInfo toDataIf()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SaveAmtActivityInfo toBeanIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSave_amt()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return this.save_amt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSortid()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return this.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_reset()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.is_reset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSave_amt(long _v_)
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     xdb.Logs.logIf(new LogKey(this, "save_amt")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 243 */         new xdb.logs.LogLong(this, SaveAmtActivityInfo.this.save_amt)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 247 */             SaveAmtActivityInfo.this.save_amt = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 251 */     });
/* 252 */     this.save_amt = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSortid(int _v_)
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     xdb.Logs.logIf(new LogKey(this, "sortid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 264 */         new xdb.logs.LogInt(this, SaveAmtActivityInfo.this.sortid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 268 */             SaveAmtActivityInfo.this.sortid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 272 */     });
/* 273 */     this.sortid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_reset(boolean _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "is_reset")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 285 */         new xdb.logs.LogObject(this, Boolean.valueOf(SaveAmtActivityInfo.this.is_reset))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             SaveAmtActivityInfo.this.is_reset = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.is_reset = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     SaveAmtActivityInfo _o_ = null;
/* 302 */     if ((_o1_ instanceof SaveAmtActivityInfo)) { _o_ = (SaveAmtActivityInfo)_o1_;
/* 303 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 304 */       return false;
/* 305 */     if (this.save_amt != _o_.save_amt) return false;
/* 306 */     if (this.sortid != _o_.sortid) return false;
/* 307 */     if (this.is_reset != _o_.is_reset) return false;
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     int _h_ = 0;
/* 316 */     _h_ = (int)(_h_ + this.save_amt);
/* 317 */     _h_ += this.sortid;
/* 318 */     _h_ += (this.is_reset ? 1231 : 1237);
/* 319 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     StringBuilder _sb_ = new StringBuilder();
/* 327 */     _sb_.append("(");
/* 328 */     _sb_.append(this.save_amt);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.sortid);
/* 331 */     _sb_.append(",");
/* 332 */     _sb_.append(this.is_reset);
/* 333 */     _sb_.append(")");
/* 334 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 340 */     ListenableBean lb = new ListenableBean();
/* 341 */     lb.add(new ListenableChanged().setVarName("save_amt"));
/* 342 */     lb.add(new ListenableChanged().setVarName("sortid"));
/* 343 */     lb.add(new ListenableChanged().setVarName("is_reset"));
/* 344 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SaveAmtActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     SaveAmtActivityInfo nThis() {
/* 351 */       return SaveAmtActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 357 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SaveAmtActivityInfo copy()
/*     */     {
/* 363 */       return SaveAmtActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SaveAmtActivityInfo toData()
/*     */     {
/* 369 */       return SaveAmtActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SaveAmtActivityInfo toBean()
/*     */     {
/* 374 */       return SaveAmtActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SaveAmtActivityInfo toDataIf()
/*     */     {
/* 380 */       return SaveAmtActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SaveAmtActivityInfo toBeanIf()
/*     */     {
/* 385 */       return SaveAmtActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSave_amt()
/*     */     {
/* 392 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 393 */       return SaveAmtActivityInfo.this.save_amt;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 400 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 401 */       return SaveAmtActivityInfo.this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_reset()
/*     */     {
/* 408 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 409 */       return SaveAmtActivityInfo.this.is_reset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSave_amt(long _v_)
/*     */     {
/* 416 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 417 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 424 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 425 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_reset(boolean _v_)
/*     */     {
/* 432 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 439 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 440 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 446 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 447 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 453 */       return SaveAmtActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       return SaveAmtActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 465 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 466 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 472 */       return SaveAmtActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 478 */       return SaveAmtActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 484 */       SaveAmtActivityInfo.this._xdb_verify_unsafe_();
/* 485 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 491 */       return SaveAmtActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 497 */       return SaveAmtActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 503 */       return SaveAmtActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 509 */       return SaveAmtActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 515 */       return SaveAmtActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 521 */       return SaveAmtActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 527 */       return SaveAmtActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SaveAmtActivityInfo
/*     */   {
/*     */     private long save_amt;
/*     */     
/*     */     private int sortid;
/*     */     
/*     */     private boolean is_reset;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 548 */       this.save_amt = 0L;
/* 549 */       this.is_reset = false;
/*     */     }
/*     */     
/*     */     Data(xbean.SaveAmtActivityInfo _o1_)
/*     */     {
/* 554 */       if ((_o1_ instanceof SaveAmtActivityInfo)) { assign((SaveAmtActivityInfo)_o1_);
/* 555 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 556 */       } else if ((_o1_ instanceof SaveAmtActivityInfo.Const)) assign(((SaveAmtActivityInfo.Const)_o1_).nThis()); else {
/* 557 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SaveAmtActivityInfo _o_) {
/* 562 */       this.save_amt = _o_.save_amt;
/* 563 */       this.sortid = _o_.sortid;
/* 564 */       this.is_reset = _o_.is_reset;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 569 */       this.save_amt = _o_.save_amt;
/* 570 */       this.sortid = _o_.sortid;
/* 571 */       this.is_reset = _o_.is_reset;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 577 */       _os_.marshal(this.save_amt);
/* 578 */       _os_.marshal(this.sortid);
/* 579 */       _os_.marshal(this.is_reset);
/* 580 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 586 */       this.save_amt = _os_.unmarshal_long();
/* 587 */       this.sortid = _os_.unmarshal_int();
/* 588 */       this.is_reset = _os_.unmarshal_boolean();
/* 589 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 595 */       int _size_ = 0;
/* 596 */       _size_ += CodedOutputStream.computeInt64Size(1, this.save_amt);
/* 597 */       _size_ += CodedOutputStream.computeInt32Size(2, this.sortid);
/* 598 */       _size_ += CodedOutputStream.computeBoolSize(3, this.is_reset);
/* 599 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 607 */         _output_.writeInt64(1, this.save_amt);
/* 608 */         _output_.writeInt32(2, this.sortid);
/* 609 */         _output_.writeBool(3, this.is_reset);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 613 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 615 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 623 */         boolean done = false;
/* 624 */         while (!done)
/*     */         {
/* 626 */           int tag = _input_.readTag();
/* 627 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 631 */             done = true;
/* 632 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 636 */             this.save_amt = _input_.readInt64();
/* 637 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 641 */             this.sortid = _input_.readInt32();
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 646 */             this.is_reset = _input_.readBool();
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SaveAmtActivityInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SaveAmtActivityInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SaveAmtActivityInfo toBean()
/*     */     {
/* 685 */       return new SaveAmtActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SaveAmtActivityInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SaveAmtActivityInfo toBeanIf()
/*     */     {
/* 696 */       return new SaveAmtActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSave_amt()
/*     */     {
/* 733 */       return this.save_amt;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 740 */       return this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_reset()
/*     */     {
/* 747 */       return this.is_reset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSave_amt(long _v_)
/*     */     {
/* 754 */       this.save_amt = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 761 */       this.sortid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_reset(boolean _v_)
/*     */     {
/* 768 */       this.is_reset = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 774 */       if (!(_o1_ instanceof Data)) return false;
/* 775 */       Data _o_ = (Data)_o1_;
/* 776 */       if (this.save_amt != _o_.save_amt) return false;
/* 777 */       if (this.sortid != _o_.sortid) return false;
/* 778 */       if (this.is_reset != _o_.is_reset) return false;
/* 779 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 785 */       int _h_ = 0;
/* 786 */       _h_ = (int)(_h_ + this.save_amt);
/* 787 */       _h_ += this.sortid;
/* 788 */       _h_ += (this.is_reset ? 1231 : 1237);
/* 789 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 795 */       StringBuilder _sb_ = new StringBuilder();
/* 796 */       _sb_.append("(");
/* 797 */       _sb_.append(this.save_amt);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.sortid);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.is_reset);
/* 802 */       _sb_.append(")");
/* 803 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SaveAmtActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */