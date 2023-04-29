/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class LeiTaiFight extends XBean implements xbean.LeiTaiFight
/*     */ {
/*     */   private long activeroleid;
/*     */   private int activeteamnum;
/*     */   private long passiveroleid;
/*     */   private int passiveteamnum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.activeroleid = 0L;
/*  25 */     this.activeteamnum = 0;
/*  26 */     this.passiveroleid = 0L;
/*  27 */     this.passiveteamnum = 0;
/*     */   }
/*     */   
/*     */   LeiTaiFight(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.activeteamnum = 0;
/*  34 */     this.passiveteamnum = 0;
/*     */   }
/*     */   
/*     */   public LeiTaiFight()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LeiTaiFight(LeiTaiFight _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LeiTaiFight(xbean.LeiTaiFight _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof LeiTaiFight)) { assign((LeiTaiFight)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LeiTaiFight _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.activeroleid = _o_.activeroleid;
/*  60 */     this.activeteamnum = _o_.activeteamnum;
/*  61 */     this.passiveroleid = _o_.passiveroleid;
/*  62 */     this.passiveteamnum = _o_.passiveteamnum;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.activeroleid = _o_.activeroleid;
/*  68 */     this.activeteamnum = _o_.activeteamnum;
/*  69 */     this.passiveroleid = _o_.passiveroleid;
/*  70 */     this.passiveteamnum = _o_.passiveteamnum;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.activeroleid);
/*  78 */     _os_.marshal(this.activeteamnum);
/*  79 */     _os_.marshal(this.passiveroleid);
/*  80 */     _os_.marshal(this.passiveteamnum);
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     this.activeroleid = _os_.unmarshal_long();
/*  89 */     this.activeteamnum = _os_.unmarshal_int();
/*  90 */     this.passiveroleid = _os_.unmarshal_long();
/*  91 */     this.passiveteamnum = _os_.unmarshal_int();
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     int _size_ = 0;
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(1, this.activeroleid);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(2, this.activeteamnum);
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(3, this.passiveroleid);
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(4, this.passiveteamnum);
/* 104 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       _output_.writeInt64(1, this.activeroleid);
/* 114 */       _output_.writeInt32(2, this.activeteamnum);
/* 115 */       _output_.writeInt64(3, this.passiveroleid);
/* 116 */       _output_.writeInt32(4, this.passiveteamnum);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 144 */           this.activeroleid = _input_.readInt64();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 149 */           this.activeteamnum = _input_.readInt32();
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 154 */           this.passiveroleid = _input_.readInt64();
/* 155 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 159 */           this.passiveteamnum = _input_.readInt32();
/* 160 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 164 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 166 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 175 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 181 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LeiTaiFight copy()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new LeiTaiFight(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LeiTaiFight toData()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LeiTaiFight toBean()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new LeiTaiFight(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LeiTaiFight toDataIf()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LeiTaiFight toBeanIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getActiveroleid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.activeroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getActiveteamnum()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.activeteamnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPassiveroleid()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.passiveroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPassiveteamnum()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this.passiveteamnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActiveroleid(long _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "activeroleid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 265 */         new xdb.logs.LogLong(this, LeiTaiFight.this.activeroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             LeiTaiFight.this.activeroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.activeroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActiveteamnum(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "activeteamnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 286 */         new xdb.logs.LogInt(this, LeiTaiFight.this.activeteamnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             LeiTaiFight.this.activeteamnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.activeteamnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPassiveroleid(long _v_)
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     xdb.Logs.logIf(new LogKey(this, "passiveroleid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 307 */         new xdb.logs.LogLong(this, LeiTaiFight.this.passiveroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 311 */             LeiTaiFight.this.passiveroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 315 */     });
/* 316 */     this.passiveroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPassiveteamnum(int _v_)
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     xdb.Logs.logIf(new LogKey(this, "passiveteamnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 328 */         new xdb.logs.LogInt(this, LeiTaiFight.this.passiveteamnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 332 */             LeiTaiFight.this.passiveteamnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 336 */     });
/* 337 */     this.passiveteamnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     LeiTaiFight _o_ = null;
/* 345 */     if ((_o1_ instanceof LeiTaiFight)) { _o_ = (LeiTaiFight)_o1_;
/* 346 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 347 */       return false;
/* 348 */     if (this.activeroleid != _o_.activeroleid) return false;
/* 349 */     if (this.activeteamnum != _o_.activeteamnum) return false;
/* 350 */     if (this.passiveroleid != _o_.passiveroleid) return false;
/* 351 */     if (this.passiveteamnum != _o_.passiveteamnum) return false;
/* 352 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     int _h_ = 0;
/* 360 */     _h_ = (int)(_h_ + this.activeroleid);
/* 361 */     _h_ += this.activeteamnum;
/* 362 */     _h_ = (int)(_h_ + this.passiveroleid);
/* 363 */     _h_ += this.passiveteamnum;
/* 364 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 370 */     _xdb_verify_unsafe_();
/* 371 */     StringBuilder _sb_ = new StringBuilder();
/* 372 */     _sb_.append("(");
/* 373 */     _sb_.append(this.activeroleid);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.activeteamnum);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.passiveroleid);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.passiveteamnum);
/* 380 */     _sb_.append(")");
/* 381 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 387 */     ListenableBean lb = new ListenableBean();
/* 388 */     lb.add(new ListenableChanged().setVarName("activeroleid"));
/* 389 */     lb.add(new ListenableChanged().setVarName("activeteamnum"));
/* 390 */     lb.add(new ListenableChanged().setVarName("passiveroleid"));
/* 391 */     lb.add(new ListenableChanged().setVarName("passiveteamnum"));
/* 392 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LeiTaiFight {
/*     */     private Const() {}
/*     */     
/*     */     LeiTaiFight nThis() {
/* 399 */       return LeiTaiFight.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LeiTaiFight copy()
/*     */     {
/* 411 */       return LeiTaiFight.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LeiTaiFight toData()
/*     */     {
/* 417 */       return LeiTaiFight.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LeiTaiFight toBean()
/*     */     {
/* 422 */       return LeiTaiFight.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LeiTaiFight toDataIf()
/*     */     {
/* 428 */       return LeiTaiFight.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LeiTaiFight toBeanIf()
/*     */     {
/* 433 */       return LeiTaiFight.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getActiveroleid()
/*     */     {
/* 440 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 441 */       return LeiTaiFight.this.activeroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActiveteamnum()
/*     */     {
/* 448 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 449 */       return LeiTaiFight.this.activeteamnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPassiveroleid()
/*     */     {
/* 456 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 457 */       return LeiTaiFight.this.passiveroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPassiveteamnum()
/*     */     {
/* 464 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 465 */       return LeiTaiFight.this.passiveteamnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActiveroleid(long _v_)
/*     */     {
/* 472 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActiveteamnum(int _v_)
/*     */     {
/* 480 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 481 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPassiveroleid(long _v_)
/*     */     {
/* 488 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPassiveteamnum(int _v_)
/*     */     {
/* 496 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 497 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 503 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 504 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 510 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 511 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 517 */       return LeiTaiFight.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       return LeiTaiFight.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 529 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 530 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 536 */       return LeiTaiFight.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 542 */       return LeiTaiFight.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 548 */       LeiTaiFight.this._xdb_verify_unsafe_();
/* 549 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 555 */       return LeiTaiFight.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 561 */       return LeiTaiFight.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 567 */       return LeiTaiFight.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 573 */       return LeiTaiFight.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 579 */       return LeiTaiFight.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 585 */       return LeiTaiFight.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 591 */       return LeiTaiFight.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LeiTaiFight
/*     */   {
/*     */     private long activeroleid;
/*     */     
/*     */     private int activeteamnum;
/*     */     
/*     */     private long passiveroleid;
/*     */     
/*     */     private int passiveteamnum;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 609 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 614 */       this.activeteamnum = 0;
/* 615 */       this.passiveteamnum = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.LeiTaiFight _o1_)
/*     */     {
/* 620 */       if ((_o1_ instanceof LeiTaiFight)) { assign((LeiTaiFight)_o1_);
/* 621 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 622 */       } else if ((_o1_ instanceof LeiTaiFight.Const)) assign(((LeiTaiFight.Const)_o1_).nThis()); else {
/* 623 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LeiTaiFight _o_) {
/* 628 */       this.activeroleid = _o_.activeroleid;
/* 629 */       this.activeteamnum = _o_.activeteamnum;
/* 630 */       this.passiveroleid = _o_.passiveroleid;
/* 631 */       this.passiveteamnum = _o_.passiveteamnum;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 636 */       this.activeroleid = _o_.activeroleid;
/* 637 */       this.activeteamnum = _o_.activeteamnum;
/* 638 */       this.passiveroleid = _o_.passiveroleid;
/* 639 */       this.passiveteamnum = _o_.passiveteamnum;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 645 */       _os_.marshal(this.activeroleid);
/* 646 */       _os_.marshal(this.activeteamnum);
/* 647 */       _os_.marshal(this.passiveroleid);
/* 648 */       _os_.marshal(this.passiveteamnum);
/* 649 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 655 */       this.activeroleid = _os_.unmarshal_long();
/* 656 */       this.activeteamnum = _os_.unmarshal_int();
/* 657 */       this.passiveroleid = _os_.unmarshal_long();
/* 658 */       this.passiveteamnum = _os_.unmarshal_int();
/* 659 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 665 */       int _size_ = 0;
/* 666 */       _size_ += CodedOutputStream.computeInt64Size(1, this.activeroleid);
/* 667 */       _size_ += CodedOutputStream.computeInt32Size(2, this.activeteamnum);
/* 668 */       _size_ += CodedOutputStream.computeInt64Size(3, this.passiveroleid);
/* 669 */       _size_ += CodedOutputStream.computeInt32Size(4, this.passiveteamnum);
/* 670 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 678 */         _output_.writeInt64(1, this.activeroleid);
/* 679 */         _output_.writeInt32(2, this.activeteamnum);
/* 680 */         _output_.writeInt64(3, this.passiveroleid);
/* 681 */         _output_.writeInt32(4, this.passiveteamnum);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 685 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 687 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 695 */         boolean done = false;
/* 696 */         while (!done)
/*     */         {
/* 698 */           int tag = _input_.readTag();
/* 699 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 703 */             done = true;
/* 704 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 708 */             this.activeroleid = _input_.readInt64();
/* 709 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 713 */             this.activeteamnum = _input_.readInt32();
/* 714 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 718 */             this.passiveroleid = _input_.readInt64();
/* 719 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 723 */             this.passiveteamnum = _input_.readInt32();
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LeiTaiFight copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LeiTaiFight toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LeiTaiFight toBean()
/*     */     {
/* 762 */       return new LeiTaiFight(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LeiTaiFight toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LeiTaiFight toBeanIf()
/*     */     {
/* 773 */       return new LeiTaiFight(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getActiveroleid()
/*     */     {
/* 810 */       return this.activeroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActiveteamnum()
/*     */     {
/* 817 */       return this.activeteamnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPassiveroleid()
/*     */     {
/* 824 */       return this.passiveroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPassiveteamnum()
/*     */     {
/* 831 */       return this.passiveteamnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActiveroleid(long _v_)
/*     */     {
/* 838 */       this.activeroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActiveteamnum(int _v_)
/*     */     {
/* 845 */       this.activeteamnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPassiveroleid(long _v_)
/*     */     {
/* 852 */       this.passiveroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPassiveteamnum(int _v_)
/*     */     {
/* 859 */       this.passiveteamnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 865 */       if (!(_o1_ instanceof Data)) return false;
/* 866 */       Data _o_ = (Data)_o1_;
/* 867 */       if (this.activeroleid != _o_.activeroleid) return false;
/* 868 */       if (this.activeteamnum != _o_.activeteamnum) return false;
/* 869 */       if (this.passiveroleid != _o_.passiveroleid) return false;
/* 870 */       if (this.passiveteamnum != _o_.passiveteamnum) return false;
/* 871 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 877 */       int _h_ = 0;
/* 878 */       _h_ = (int)(_h_ + this.activeroleid);
/* 879 */       _h_ += this.activeteamnum;
/* 880 */       _h_ = (int)(_h_ + this.passiveroleid);
/* 881 */       _h_ += this.passiveteamnum;
/* 882 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 888 */       StringBuilder _sb_ = new StringBuilder();
/* 889 */       _sb_.append("(");
/* 890 */       _sb_.append(this.activeroleid);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.activeteamnum);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.passiveroleid);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.passiveteamnum);
/* 897 */       _sb_.append(")");
/* 898 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LeiTaiFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */