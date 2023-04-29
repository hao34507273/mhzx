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
/*     */ public final class PetArenaFightAward extends XBean implements xbean.PetArenaFightAward
/*     */ {
/*     */   private int awardid;
/*     */   private int modify_cfgid;
/*     */   private int point;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.awardid = 0;
/*  23 */     this.modify_cfgid = 0;
/*  24 */     this.point = 0;
/*     */   }
/*     */   
/*     */   PetArenaFightAward(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.awardid = 0;
/*  31 */     this.modify_cfgid = 0;
/*  32 */     this.point = 0;
/*     */   }
/*     */   
/*     */   public PetArenaFightAward()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetArenaFightAward(PetArenaFightAward _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetArenaFightAward(xbean.PetArenaFightAward _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof PetArenaFightAward)) { assign((PetArenaFightAward)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetArenaFightAward _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.awardid = _o_.awardid;
/*  58 */     this.modify_cfgid = _o_.modify_cfgid;
/*  59 */     this.point = _o_.point;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.awardid = _o_.awardid;
/*  65 */     this.modify_cfgid = _o_.modify_cfgid;
/*  66 */     this.point = _o_.point;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.awardid);
/*  74 */     _os_.marshal(this.modify_cfgid);
/*  75 */     _os_.marshal(this.point);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.awardid = _os_.unmarshal_int();
/*  84 */     this.modify_cfgid = _os_.unmarshal_int();
/*  85 */     this.point = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.awardid);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.modify_cfgid);
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.awardid);
/* 107 */       _output_.writeInt32(2, this.modify_cfgid);
/* 108 */       _output_.writeInt32(3, this.point);
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
/* 136 */           this.awardid = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.modify_cfgid = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.point = _input_.readInt32();
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
/*     */   public xbean.PetArenaFightAward copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new PetArenaFightAward(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaFightAward toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetArenaFightAward toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new PetArenaFightAward(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaFightAward toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetArenaFightAward toBeanIf()
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
/*     */   public int getAwardid()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.awardid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getModify_cfgid()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.modify_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPoint()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwardid(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "awardid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogInt(this, PetArenaFightAward.this.awardid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             PetArenaFightAward.this.awardid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.awardid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setModify_cfgid(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "modify_cfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogInt(this, PetArenaFightAward.this.modify_cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             PetArenaFightAward.this.modify_cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.modify_cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoint(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "point")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogInt(this, PetArenaFightAward.this.point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             PetArenaFightAward.this.point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     PetArenaFightAward _o_ = null;
/* 303 */     if ((_o1_ instanceof PetArenaFightAward)) { _o_ = (PetArenaFightAward)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.awardid != _o_.awardid) return false;
/* 307 */     if (this.modify_cfgid != _o_.modify_cfgid) return false;
/* 308 */     if (this.point != _o_.point) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.awardid;
/* 318 */     _h_ += this.modify_cfgid;
/* 319 */     _h_ += this.point;
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.awardid);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.modify_cfgid);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.point);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("awardid"));
/* 343 */     lb.add(new ListenableChanged().setVarName("modify_cfgid"));
/* 344 */     lb.add(new ListenableChanged().setVarName("point"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetArenaFightAward {
/*     */     private Const() {}
/*     */     
/*     */     PetArenaFightAward nThis() {
/* 352 */       return PetArenaFightAward.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaFightAward copy()
/*     */     {
/* 364 */       return PetArenaFightAward.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaFightAward toData()
/*     */     {
/* 370 */       return PetArenaFightAward.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetArenaFightAward toBean()
/*     */     {
/* 375 */       return PetArenaFightAward.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaFightAward toDataIf()
/*     */     {
/* 381 */       return PetArenaFightAward.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetArenaFightAward toBeanIf()
/*     */     {
/* 386 */       return PetArenaFightAward.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAwardid()
/*     */     {
/* 393 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 394 */       return PetArenaFightAward.this.awardid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getModify_cfgid()
/*     */     {
/* 401 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 402 */       return PetArenaFightAward.this.modify_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 409 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 410 */       return PetArenaFightAward.this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardid(int _v_)
/*     */     {
/* 417 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModify_cfgid(int _v_)
/*     */     {
/* 425 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 433 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return PetArenaFightAward.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return PetArenaFightAward.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return PetArenaFightAward.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return PetArenaFightAward.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       PetArenaFightAward.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return PetArenaFightAward.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return PetArenaFightAward.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return PetArenaFightAward.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return PetArenaFightAward.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return PetArenaFightAward.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return PetArenaFightAward.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return PetArenaFightAward.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetArenaFightAward
/*     */   {
/*     */     private int awardid;
/*     */     
/*     */     private int modify_cfgid;
/*     */     
/*     */     private int point;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.awardid = 0;
/* 550 */       this.modify_cfgid = 0;
/* 551 */       this.point = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.PetArenaFightAward _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof PetArenaFightAward)) { assign((PetArenaFightAward)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof PetArenaFightAward.Const)) assign(((PetArenaFightAward.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetArenaFightAward _o_) {
/* 564 */       this.awardid = _o_.awardid;
/* 565 */       this.modify_cfgid = _o_.modify_cfgid;
/* 566 */       this.point = _o_.point;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.awardid = _o_.awardid;
/* 572 */       this.modify_cfgid = _o_.modify_cfgid;
/* 573 */       this.point = _o_.point;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.awardid);
/* 580 */       _os_.marshal(this.modify_cfgid);
/* 581 */       _os_.marshal(this.point);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.awardid = _os_.unmarshal_int();
/* 589 */       this.modify_cfgid = _os_.unmarshal_int();
/* 590 */       this.point = _os_.unmarshal_int();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.awardid);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.modify_cfgid);
/* 600 */       _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.awardid);
/* 610 */         _output_.writeInt32(2, this.modify_cfgid);
/* 611 */         _output_.writeInt32(3, this.point);
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
/* 638 */             this.awardid = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.modify_cfgid = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.point = _input_.readInt32();
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
/*     */     public xbean.PetArenaFightAward copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaFightAward toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetArenaFightAward toBean()
/*     */     {
/* 687 */       return new PetArenaFightAward(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaFightAward toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetArenaFightAward toBeanIf()
/*     */     {
/* 698 */       return new PetArenaFightAward(this, null, null);
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
/*     */     public int getAwardid()
/*     */     {
/* 735 */       return this.awardid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getModify_cfgid()
/*     */     {
/* 742 */       return this.modify_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 749 */       return this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardid(int _v_)
/*     */     {
/* 756 */       this.awardid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModify_cfgid(int _v_)
/*     */     {
/* 763 */       this.modify_cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 770 */       this.point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.awardid != _o_.awardid) return false;
/* 779 */       if (this.modify_cfgid != _o_.modify_cfgid) return false;
/* 780 */       if (this.point != _o_.point) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.awardid;
/* 789 */       _h_ += this.modify_cfgid;
/* 790 */       _h_ += this.point;
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.awardid);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.modify_cfgid);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.point);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetArenaFightAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */