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
/*     */ public final class FighterHealthInfo extends XBean implements xbean.FighterHealthInfo
/*     */ {
/*     */   private int hp;
/*     */   private int mp;
/*     */   private float anger;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.hp = 0;
/*  23 */     this.mp = 0;
/*  24 */     this.anger = 0.0F;
/*     */   }
/*     */   
/*     */   FighterHealthInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.hp = 0;
/*  31 */     this.mp = 0;
/*  32 */     this.anger = 0.0F;
/*     */   }
/*     */   
/*     */   public FighterHealthInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FighterHealthInfo(FighterHealthInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FighterHealthInfo(xbean.FighterHealthInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof FighterHealthInfo)) { assign((FighterHealthInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FighterHealthInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.hp = _o_.hp;
/*  58 */     this.mp = _o_.mp;
/*  59 */     this.anger = _o_.anger;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.hp = _o_.hp;
/*  65 */     this.mp = _o_.mp;
/*  66 */     this.anger = _o_.anger;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.hp);
/*  74 */     _os_.marshal(this.mp);
/*  75 */     _os_.marshal(this.anger);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.hp = _os_.unmarshal_int();
/*  84 */     this.mp = _os_.unmarshal_int();
/*  85 */     this.anger = _os_.unmarshal_float();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.hp);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.mp);
/*  96 */     _size_ += CodedOutputStream.computeFloatSize(3, this.anger);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.hp);
/* 107 */       _output_.writeInt32(2, this.mp);
/* 108 */       _output_.writeFloat(3, this.anger);
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
/* 136 */           this.hp = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.mp = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 29: 
/* 146 */           this.anger = _input_.readFloat();
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
/*     */   public xbean.FighterHealthInfo copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new FighterHealthInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterHealthInfo toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterHealthInfo toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new FighterHealthInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterHealthInfo toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterHealthInfo toBeanIf()
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
/*     */   public int getHp()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.hp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMp()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.mp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getAnger()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.anger;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHp(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "hp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new xdb.logs.LogInt(this, FighterHealthInfo.this.hp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             FighterHealthInfo.this.hp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.hp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMp(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "mp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogInt(this, FighterHealthInfo.this.mp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             FighterHealthInfo.this.mp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.mp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnger(float _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "anger")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new xdb.logs.LogFloat(this, FighterHealthInfo.this.anger)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             FighterHealthInfo.this.anger = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.anger = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     FighterHealthInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof FighterHealthInfo)) { _o_ = (FighterHealthInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.hp != _o_.hp) return false;
/* 307 */     if (this.mp != _o_.mp) return false;
/* 308 */     if (this.anger != _o_.anger) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.hp;
/* 318 */     _h_ += this.mp;
/* 319 */     _h_ = (int)(_h_ + this.anger);
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.hp);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.mp);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.anger);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("hp"));
/* 343 */     lb.add(new ListenableChanged().setVarName("mp"));
/* 344 */     lb.add(new ListenableChanged().setVarName("anger"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FighterHealthInfo {
/*     */     private Const() {}
/*     */     
/*     */     FighterHealthInfo nThis() {
/* 352 */       return FighterHealthInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterHealthInfo copy()
/*     */     {
/* 364 */       return FighterHealthInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterHealthInfo toData()
/*     */     {
/* 370 */       return FighterHealthInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FighterHealthInfo toBean()
/*     */     {
/* 375 */       return FighterHealthInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterHealthInfo toDataIf()
/*     */     {
/* 381 */       return FighterHealthInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FighterHealthInfo toBeanIf()
/*     */     {
/* 386 */       return FighterHealthInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHp()
/*     */     {
/* 393 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 394 */       return FighterHealthInfo.this.hp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMp()
/*     */     {
/* 401 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 402 */       return FighterHealthInfo.this.mp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public float getAnger()
/*     */     {
/* 409 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 410 */       return FighterHealthInfo.this.anger;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHp(int _v_)
/*     */     {
/* 417 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMp(int _v_)
/*     */     {
/* 425 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnger(float _v_)
/*     */     {
/* 433 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 440 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return FighterHealthInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return FighterHealthInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return FighterHealthInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return FighterHealthInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       FighterHealthInfo.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 492 */       return FighterHealthInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return FighterHealthInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return FighterHealthInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return FighterHealthInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return FighterHealthInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return FighterHealthInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return FighterHealthInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FighterHealthInfo
/*     */   {
/*     */     private int hp;
/*     */     
/*     */     private int mp;
/*     */     
/*     */     private float anger;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.hp = 0;
/* 550 */       this.mp = 0;
/* 551 */       this.anger = 0.0F;
/*     */     }
/*     */     
/*     */     Data(xbean.FighterHealthInfo _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof FighterHealthInfo)) { assign((FighterHealthInfo)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof FighterHealthInfo.Const)) assign(((FighterHealthInfo.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FighterHealthInfo _o_) {
/* 564 */       this.hp = _o_.hp;
/* 565 */       this.mp = _o_.mp;
/* 566 */       this.anger = _o_.anger;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.hp = _o_.hp;
/* 572 */       this.mp = _o_.mp;
/* 573 */       this.anger = _o_.anger;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.hp);
/* 580 */       _os_.marshal(this.mp);
/* 581 */       _os_.marshal(this.anger);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.hp = _os_.unmarshal_int();
/* 589 */       this.mp = _os_.unmarshal_int();
/* 590 */       this.anger = _os_.unmarshal_float();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.hp);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.mp);
/* 600 */       _size_ += CodedOutputStream.computeFloatSize(3, this.anger);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.hp);
/* 610 */         _output_.writeInt32(2, this.mp);
/* 611 */         _output_.writeFloat(3, this.anger);
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
/* 638 */             this.hp = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.mp = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 29: 
/* 648 */             this.anger = _input_.readFloat();
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
/*     */     public xbean.FighterHealthInfo copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterHealthInfo toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FighterHealthInfo toBean()
/*     */     {
/* 687 */       return new FighterHealthInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterHealthInfo toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FighterHealthInfo toBeanIf()
/*     */     {
/* 698 */       return new FighterHealthInfo(this, null, null);
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
/*     */     public int getHp()
/*     */     {
/* 735 */       return this.hp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMp()
/*     */     {
/* 742 */       return this.mp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public float getAnger()
/*     */     {
/* 749 */       return this.anger;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHp(int _v_)
/*     */     {
/* 756 */       this.hp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMp(int _v_)
/*     */     {
/* 763 */       this.mp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnger(float _v_)
/*     */     {
/* 770 */       this.anger = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.hp != _o_.hp) return false;
/* 779 */       if (this.mp != _o_.mp) return false;
/* 780 */       if (this.anger != _o_.anger) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.hp;
/* 789 */       _h_ += this.mp;
/* 790 */       _h_ = (int)(_h_ + this.anger);
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.hp);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.mp);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.anger);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FighterHealthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */