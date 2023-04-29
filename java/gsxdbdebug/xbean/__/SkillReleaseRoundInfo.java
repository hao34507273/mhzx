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
/*     */ public final class SkillReleaseRoundInfo extends XBean implements xbean.SkillReleaseRoundInfo
/*     */ {
/*     */   private int roundnumber;
/*     */   private boolean isok;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.roundnumber = 0;
/*  21 */     this.isok = false;
/*     */   }
/*     */   
/*     */   SkillReleaseRoundInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public SkillReleaseRoundInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SkillReleaseRoundInfo(SkillReleaseRoundInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SkillReleaseRoundInfo(xbean.SkillReleaseRoundInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof SkillReleaseRoundInfo)) { assign((SkillReleaseRoundInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SkillReleaseRoundInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.roundnumber = _o_.roundnumber;
/*  52 */     this.isok = _o_.isok;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.roundnumber = _o_.roundnumber;
/*  58 */     this.isok = _o_.isok;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.roundnumber);
/*  66 */     _os_.marshal(this.isok);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.roundnumber = _os_.unmarshal_int();
/*  75 */     this.isok = _os_.unmarshal_boolean();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt32Size(1, this.roundnumber);
/*  85 */     _size_ += CodedOutputStream.computeBoolSize(2, this.isok);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt32(1, this.roundnumber);
/*  96 */       _output_.writeBool(2, this.isok);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.roundnumber = _input_.readInt32();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.isok = _input_.readBool();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillReleaseRoundInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new SkillReleaseRoundInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillReleaseRoundInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillReleaseRoundInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new SkillReleaseRoundInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillReleaseRoundInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillReleaseRoundInfo toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRoundnumber()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.roundnumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsok()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.isok;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoundnumber(int _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "roundnumber")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogInt(this, SkillReleaseRoundInfo.this.roundnumber)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             SkillReleaseRoundInfo.this.roundnumber = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.roundnumber = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsok(boolean _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "isok")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogObject(this, Boolean.valueOf(SkillReleaseRoundInfo.this.isok))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             SkillReleaseRoundInfo.this.isok = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.isok = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     SkillReleaseRoundInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof SkillReleaseRoundInfo)) { _o_ = (SkillReleaseRoundInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.roundnumber != _o_.roundnumber) return false;
/* 261 */     if (this.isok != _o_.isok) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += this.roundnumber;
/* 271 */     _h_ += (this.isok ? 1231 : 1237);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.roundnumber);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.isok);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roundnumber"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isok"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SkillReleaseRoundInfo {
/*     */     private Const() {}
/*     */     
/*     */     SkillReleaseRoundInfo nThis() {
/* 301 */       return SkillReleaseRoundInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillReleaseRoundInfo copy()
/*     */     {
/* 313 */       return SkillReleaseRoundInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillReleaseRoundInfo toData()
/*     */     {
/* 319 */       return SkillReleaseRoundInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SkillReleaseRoundInfo toBean()
/*     */     {
/* 324 */       return SkillReleaseRoundInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillReleaseRoundInfo toDataIf()
/*     */     {
/* 330 */       return SkillReleaseRoundInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SkillReleaseRoundInfo toBeanIf()
/*     */     {
/* 335 */       return SkillReleaseRoundInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoundnumber()
/*     */     {
/* 342 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 343 */       return SkillReleaseRoundInfo.this.roundnumber;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsok()
/*     */     {
/* 350 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 351 */       return SkillReleaseRoundInfo.this.isok;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoundnumber(int _v_)
/*     */     {
/* 358 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsok(boolean _v_)
/*     */     {
/* 366 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return SkillReleaseRoundInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return SkillReleaseRoundInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return SkillReleaseRoundInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return SkillReleaseRoundInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       SkillReleaseRoundInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return SkillReleaseRoundInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return SkillReleaseRoundInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return SkillReleaseRoundInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return SkillReleaseRoundInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return SkillReleaseRoundInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return SkillReleaseRoundInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return SkillReleaseRoundInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SkillReleaseRoundInfo
/*     */   {
/*     */     private int roundnumber;
/*     */     
/*     */     private boolean isok;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.SkillReleaseRoundInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof SkillReleaseRoundInfo)) { assign((SkillReleaseRoundInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof SkillReleaseRoundInfo.Const)) assign(((SkillReleaseRoundInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SkillReleaseRoundInfo _o_) {
/* 492 */       this.roundnumber = _o_.roundnumber;
/* 493 */       this.isok = _o_.isok;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.roundnumber = _o_.roundnumber;
/* 499 */       this.isok = _o_.isok;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.roundnumber);
/* 506 */       _os_.marshal(this.isok);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.roundnumber = _os_.unmarshal_int();
/* 514 */       this.isok = _os_.unmarshal_boolean();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt32Size(1, this.roundnumber);
/* 523 */       _size_ += CodedOutputStream.computeBoolSize(2, this.isok);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt32(1, this.roundnumber);
/* 533 */         _output_.writeBool(2, this.isok);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.roundnumber = _input_.readInt32();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.isok = _input_.readBool();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillReleaseRoundInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillReleaseRoundInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SkillReleaseRoundInfo toBean()
/*     */     {
/* 604 */       return new SkillReleaseRoundInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillReleaseRoundInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SkillReleaseRoundInfo toBeanIf()
/*     */     {
/* 615 */       return new SkillReleaseRoundInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoundnumber()
/*     */     {
/* 652 */       return this.roundnumber;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsok()
/*     */     {
/* 659 */       return this.isok;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoundnumber(int _v_)
/*     */     {
/* 666 */       this.roundnumber = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsok(boolean _v_)
/*     */     {
/* 673 */       this.isok = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.roundnumber != _o_.roundnumber) return false;
/* 682 */       if (this.isok != _o_.isok) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += this.roundnumber;
/* 691 */       _h_ += (this.isok ? 1231 : 1237);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.roundnumber);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.isok);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SkillReleaseRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */