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
/*     */ public final class SkillBuffResultInfo extends XBean implements xbean.SkillBuffResultInfo
/*     */ {
/*     */   private int roundnumber;
/*     */   private boolean isok;
/*     */   private int buff;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.roundnumber = 0;
/*  23 */     this.isok = false;
/*  24 */     this.buff = 0;
/*     */   }
/*     */   
/*     */   SkillBuffResultInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public SkillBuffResultInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SkillBuffResultInfo(SkillBuffResultInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SkillBuffResultInfo(xbean.SkillBuffResultInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof SkillBuffResultInfo)) { assign((SkillBuffResultInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SkillBuffResultInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.roundnumber = _o_.roundnumber;
/*  55 */     this.isok = _o_.isok;
/*  56 */     this.buff = _o_.buff;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.roundnumber = _o_.roundnumber;
/*  62 */     this.isok = _o_.isok;
/*  63 */     this.buff = _o_.buff;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.roundnumber);
/*  71 */     _os_.marshal(this.isok);
/*  72 */     _os_.marshal(this.buff);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.roundnumber = _os_.unmarshal_int();
/*  81 */     this.isok = _os_.unmarshal_boolean();
/*  82 */     this.buff = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.roundnumber);
/*  92 */     _size_ += CodedOutputStream.computeBoolSize(2, this.isok);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.buff);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.roundnumber);
/* 104 */       _output_.writeBool(2, this.isok);
/* 105 */       _output_.writeInt32(3, this.buff);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.roundnumber = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.isok = _input_.readBool();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.buff = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillBuffResultInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new SkillBuffResultInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillBuffResultInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillBuffResultInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new SkillBuffResultInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillBuffResultInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillBuffResultInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRoundnumber()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.roundnumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsok()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.isok;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBuff()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.buff;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoundnumber(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "roundnumber")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, SkillBuffResultInfo.this.roundnumber)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             SkillBuffResultInfo.this.roundnumber = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.roundnumber = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsok(boolean _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "isok")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogObject(this, Boolean.valueOf(SkillBuffResultInfo.this.isok))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             SkillBuffResultInfo.this.isok = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.isok = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBuff(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "buff")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, SkillBuffResultInfo.this.buff)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             SkillBuffResultInfo.this.buff = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.buff = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     SkillBuffResultInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof SkillBuffResultInfo)) { _o_ = (SkillBuffResultInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.roundnumber != _o_.roundnumber) return false;
/* 304 */     if (this.isok != _o_.isok) return false;
/* 305 */     if (this.buff != _o_.buff) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.roundnumber;
/* 315 */     _h_ += (this.isok ? 1231 : 1237);
/* 316 */     _h_ += this.buff;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.roundnumber);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.isok);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.buff);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("roundnumber"));
/* 340 */     lb.add(new ListenableChanged().setVarName("isok"));
/* 341 */     lb.add(new ListenableChanged().setVarName("buff"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SkillBuffResultInfo {
/*     */     private Const() {}
/*     */     
/*     */     SkillBuffResultInfo nThis() {
/* 349 */       return SkillBuffResultInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResultInfo copy()
/*     */     {
/* 361 */       return SkillBuffResultInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResultInfo toData()
/*     */     {
/* 367 */       return SkillBuffResultInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResultInfo toBean()
/*     */     {
/* 372 */       return SkillBuffResultInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResultInfo toDataIf()
/*     */     {
/* 378 */       return SkillBuffResultInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResultInfo toBeanIf()
/*     */     {
/* 383 */       return SkillBuffResultInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoundnumber()
/*     */     {
/* 390 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 391 */       return SkillBuffResultInfo.this.roundnumber;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsok()
/*     */     {
/* 398 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 399 */       return SkillBuffResultInfo.this.isok;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBuff()
/*     */     {
/* 406 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 407 */       return SkillBuffResultInfo.this.buff;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoundnumber(int _v_)
/*     */     {
/* 414 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsok(boolean _v_)
/*     */     {
/* 422 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBuff(int _v_)
/*     */     {
/* 430 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return SkillBuffResultInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return SkillBuffResultInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return SkillBuffResultInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return SkillBuffResultInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       SkillBuffResultInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return SkillBuffResultInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return SkillBuffResultInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return SkillBuffResultInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return SkillBuffResultInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return SkillBuffResultInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return SkillBuffResultInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return SkillBuffResultInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SkillBuffResultInfo
/*     */   {
/*     */     private int roundnumber;
/*     */     
/*     */     private boolean isok;
/*     */     
/*     */     private int buff;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.SkillBuffResultInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof SkillBuffResultInfo)) { assign((SkillBuffResultInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof SkillBuffResultInfo.Const)) assign(((SkillBuffResultInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SkillBuffResultInfo _o_) {
/* 558 */       this.roundnumber = _o_.roundnumber;
/* 559 */       this.isok = _o_.isok;
/* 560 */       this.buff = _o_.buff;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.roundnumber = _o_.roundnumber;
/* 566 */       this.isok = _o_.isok;
/* 567 */       this.buff = _o_.buff;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.roundnumber);
/* 574 */       _os_.marshal(this.isok);
/* 575 */       _os_.marshal(this.buff);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.roundnumber = _os_.unmarshal_int();
/* 583 */       this.isok = _os_.unmarshal_boolean();
/* 584 */       this.buff = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.roundnumber);
/* 593 */       _size_ += CodedOutputStream.computeBoolSize(2, this.isok);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.buff);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.roundnumber);
/* 604 */         _output_.writeBool(2, this.isok);
/* 605 */         _output_.writeInt32(3, this.buff);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.roundnumber = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.isok = _input_.readBool();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.buff = _input_.readInt32();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResultInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResultInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResultInfo toBean()
/*     */     {
/* 681 */       return new SkillBuffResultInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResultInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResultInfo toBeanIf()
/*     */     {
/* 692 */       return new SkillBuffResultInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoundnumber()
/*     */     {
/* 729 */       return this.roundnumber;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsok()
/*     */     {
/* 736 */       return this.isok;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBuff()
/*     */     {
/* 743 */       return this.buff;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoundnumber(int _v_)
/*     */     {
/* 750 */       this.roundnumber = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsok(boolean _v_)
/*     */     {
/* 757 */       this.isok = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBuff(int _v_)
/*     */     {
/* 764 */       this.buff = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.roundnumber != _o_.roundnumber) return false;
/* 773 */       if (this.isok != _o_.isok) return false;
/* 774 */       if (this.buff != _o_.buff) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.roundnumber;
/* 783 */       _h_ += (this.isok ? 1231 : 1237);
/* 784 */       _h_ += this.buff;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.roundnumber);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.isok);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.buff);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SkillBuffResultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */