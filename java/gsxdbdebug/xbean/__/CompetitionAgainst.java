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
/*     */ public final class CompetitionAgainst extends XBean implements xbean.CompetitionAgainst
/*     */ {
/*     */   private boolean finished;
/*     */   private long mercenary_faction;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.finished = false;
/*  21 */     this.mercenary_faction = 0L;
/*     */   }
/*     */   
/*     */   CompetitionAgainst(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.finished = false;
/*  28 */     this.mercenary_faction = 0L;
/*     */   }
/*     */   
/*     */   public CompetitionAgainst()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CompetitionAgainst(CompetitionAgainst _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CompetitionAgainst(xbean.CompetitionAgainst _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CompetitionAgainst)) { assign((CompetitionAgainst)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CompetitionAgainst _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.finished = _o_.finished;
/*  54 */     this.mercenary_faction = _o_.mercenary_faction;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.finished = _o_.finished;
/*  60 */     this.mercenary_faction = _o_.mercenary_faction;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.finished);
/*  68 */     _os_.marshal(this.mercenary_faction);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.finished = _os_.unmarshal_boolean();
/*  77 */     this.mercenary_faction = _os_.unmarshal_long();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeBoolSize(1, this.finished);
/*  87 */     _size_ += CodedOutputStream.computeInt64Size(2, this.mercenary_faction);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeBool(1, this.finished);
/*  98 */       _output_.writeInt64(2, this.mercenary_faction);
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
/* 126 */           this.finished = _input_.readBool();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.mercenary_faction = _input_.readInt64();
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
/*     */   public xbean.CompetitionAgainst copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new CompetitionAgainst(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CompetitionAgainst toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CompetitionAgainst toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new CompetitionAgainst(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CompetitionAgainst toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CompetitionAgainst toBeanIf()
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
/*     */   public boolean getFinished()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.finished;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMercenary_faction()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.mercenary_faction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFinished(boolean _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "finished")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new xdb.logs.LogObject(this, Boolean.valueOf(CompetitionAgainst.this.finished))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             CompetitionAgainst.this.finished = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.finished = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMercenary_faction(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "mercenary_faction")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogLong(this, CompetitionAgainst.this.mercenary_faction)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             CompetitionAgainst.this.mercenary_faction = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.mercenary_faction = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     CompetitionAgainst _o_ = null;
/* 259 */     if ((_o1_ instanceof CompetitionAgainst)) { _o_ = (CompetitionAgainst)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.finished != _o_.finished) return false;
/* 263 */     if (this.mercenary_faction != _o_.mercenary_faction) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ += (this.finished ? 1231 : 1237);
/* 273 */     _h_ = (int)(_h_ + this.mercenary_faction);
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.finished);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.mercenary_faction);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     ListenableBean lb = new ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("finished"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mercenary_faction"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CompetitionAgainst {
/*     */     private Const() {}
/*     */     
/*     */     CompetitionAgainst nThis() {
/* 303 */       return CompetitionAgainst.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionAgainst copy()
/*     */     {
/* 315 */       return CompetitionAgainst.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionAgainst toData()
/*     */     {
/* 321 */       return CompetitionAgainst.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CompetitionAgainst toBean()
/*     */     {
/* 326 */       return CompetitionAgainst.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionAgainst toDataIf()
/*     */     {
/* 332 */       return CompetitionAgainst.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CompetitionAgainst toBeanIf()
/*     */     {
/* 337 */       return CompetitionAgainst.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getFinished()
/*     */     {
/* 344 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 345 */       return CompetitionAgainst.this.finished;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMercenary_faction()
/*     */     {
/* 352 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 353 */       return CompetitionAgainst.this.mercenary_faction;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinished(boolean _v_)
/*     */     {
/* 360 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMercenary_faction(long _v_)
/*     */     {
/* 368 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return CompetitionAgainst.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return CompetitionAgainst.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return CompetitionAgainst.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return CompetitionAgainst.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       CompetitionAgainst.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return CompetitionAgainst.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return CompetitionAgainst.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return CompetitionAgainst.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return CompetitionAgainst.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return CompetitionAgainst.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return CompetitionAgainst.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return CompetitionAgainst.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CompetitionAgainst
/*     */   {
/*     */     private boolean finished;
/*     */     
/*     */     private long mercenary_faction;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.finished = false;
/* 483 */       this.mercenary_faction = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.CompetitionAgainst _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof CompetitionAgainst)) { assign((CompetitionAgainst)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof CompetitionAgainst.Const)) assign(((CompetitionAgainst.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CompetitionAgainst _o_) {
/* 496 */       this.finished = _o_.finished;
/* 497 */       this.mercenary_faction = _o_.mercenary_faction;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.finished = _o_.finished;
/* 503 */       this.mercenary_faction = _o_.mercenary_faction;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.finished);
/* 510 */       _os_.marshal(this.mercenary_faction);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.finished = _os_.unmarshal_boolean();
/* 518 */       this.mercenary_faction = _os_.unmarshal_long();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeBoolSize(1, this.finished);
/* 527 */       _size_ += CodedOutputStream.computeInt64Size(2, this.mercenary_faction);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeBool(1, this.finished);
/* 537 */         _output_.writeInt64(2, this.mercenary_faction);
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
/* 564 */             this.finished = _input_.readBool();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.mercenary_faction = _input_.readInt64();
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
/*     */     public xbean.CompetitionAgainst copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionAgainst toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CompetitionAgainst toBean()
/*     */     {
/* 608 */       return new CompetitionAgainst(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionAgainst toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CompetitionAgainst toBeanIf()
/*     */     {
/* 619 */       return new CompetitionAgainst(this, null, null);
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
/*     */     public boolean getFinished()
/*     */     {
/* 656 */       return this.finished;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMercenary_faction()
/*     */     {
/* 663 */       return this.mercenary_faction;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinished(boolean _v_)
/*     */     {
/* 670 */       this.finished = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMercenary_faction(long _v_)
/*     */     {
/* 677 */       this.mercenary_faction = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.finished != _o_.finished) return false;
/* 686 */       if (this.mercenary_faction != _o_.mercenary_faction) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ += (this.finished ? 1231 : 1237);
/* 695 */       _h_ = (int)(_h_ + this.mercenary_faction);
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.finished);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.mercenary_faction);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CompetitionAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */