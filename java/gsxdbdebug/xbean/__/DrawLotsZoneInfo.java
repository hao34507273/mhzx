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
/*     */ public final class DrawLotsZoneInfo extends XBean implements xbean.DrawLotsZoneInfo
/*     */ {
/*     */   private int zone;
/*     */   private int active;
/*     */   private int mailed;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.zone = 0;
/*  23 */     this.active = 0;
/*  24 */     this.mailed = 0;
/*     */   }
/*     */   
/*     */   DrawLotsZoneInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.zone = 0;
/*  31 */     this.active = 0;
/*  32 */     this.mailed = 0;
/*     */   }
/*     */   
/*     */   public DrawLotsZoneInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DrawLotsZoneInfo(DrawLotsZoneInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DrawLotsZoneInfo(xbean.DrawLotsZoneInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof DrawLotsZoneInfo)) { assign((DrawLotsZoneInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DrawLotsZoneInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.zone = _o_.zone;
/*  58 */     this.active = _o_.active;
/*  59 */     this.mailed = _o_.mailed;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.zone = _o_.zone;
/*  65 */     this.active = _o_.active;
/*  66 */     this.mailed = _o_.mailed;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.zone);
/*  74 */     _os_.marshal(this.active);
/*  75 */     _os_.marshal(this.mailed);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.zone = _os_.unmarshal_int();
/*  84 */     this.active = _os_.unmarshal_int();
/*  85 */     this.mailed = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.zone);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.active);
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(3, this.mailed);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.zone);
/* 107 */       _output_.writeInt32(2, this.active);
/* 108 */       _output_.writeInt32(3, this.mailed);
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
/* 136 */           this.zone = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.active = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.mailed = _input_.readInt32();
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
/*     */   public xbean.DrawLotsZoneInfo copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new DrawLotsZoneInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawLotsZoneInfo toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawLotsZoneInfo toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new DrawLotsZoneInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawLotsZoneInfo toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawLotsZoneInfo toBeanIf()
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
/*     */   public int getZone()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.zone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getActive()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMailed()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.mailed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZone(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "zone")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogInt(this, DrawLotsZoneInfo.this.zone)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             DrawLotsZoneInfo.this.zone = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.zone = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "active")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogInt(this, DrawLotsZoneInfo.this.active)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             DrawLotsZoneInfo.this.active = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.active = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMailed(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "mailed")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogInt(this, DrawLotsZoneInfo.this.mailed)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             DrawLotsZoneInfo.this.mailed = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.mailed = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     DrawLotsZoneInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof DrawLotsZoneInfo)) { _o_ = (DrawLotsZoneInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.zone != _o_.zone) return false;
/* 307 */     if (this.active != _o_.active) return false;
/* 308 */     if (this.mailed != _o_.mailed) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.zone;
/* 318 */     _h_ += this.active;
/* 319 */     _h_ += this.mailed;
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.zone);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.active);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.mailed);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("zone"));
/* 343 */     lb.add(new ListenableChanged().setVarName("active"));
/* 344 */     lb.add(new ListenableChanged().setVarName("mailed"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DrawLotsZoneInfo {
/*     */     private Const() {}
/*     */     
/*     */     DrawLotsZoneInfo nThis() {
/* 352 */       return DrawLotsZoneInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawLotsZoneInfo copy()
/*     */     {
/* 364 */       return DrawLotsZoneInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawLotsZoneInfo toData()
/*     */     {
/* 370 */       return DrawLotsZoneInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DrawLotsZoneInfo toBean()
/*     */     {
/* 375 */       return DrawLotsZoneInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawLotsZoneInfo toDataIf()
/*     */     {
/* 381 */       return DrawLotsZoneInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DrawLotsZoneInfo toBeanIf()
/*     */     {
/* 386 */       return DrawLotsZoneInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZone()
/*     */     {
/* 393 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 394 */       return DrawLotsZoneInfo.this.zone;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActive()
/*     */     {
/* 401 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 402 */       return DrawLotsZoneInfo.this.active;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMailed()
/*     */     {
/* 409 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 410 */       return DrawLotsZoneInfo.this.mailed;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZone(int _v_)
/*     */     {
/* 417 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActive(int _v_)
/*     */     {
/* 425 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMailed(int _v_)
/*     */     {
/* 433 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return DrawLotsZoneInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return DrawLotsZoneInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return DrawLotsZoneInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return DrawLotsZoneInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       DrawLotsZoneInfo.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return DrawLotsZoneInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return DrawLotsZoneInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return DrawLotsZoneInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return DrawLotsZoneInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return DrawLotsZoneInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return DrawLotsZoneInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return DrawLotsZoneInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DrawLotsZoneInfo
/*     */   {
/*     */     private int zone;
/*     */     
/*     */     private int active;
/*     */     
/*     */     private int mailed;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.zone = 0;
/* 550 */       this.active = 0;
/* 551 */       this.mailed = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.DrawLotsZoneInfo _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof DrawLotsZoneInfo)) { assign((DrawLotsZoneInfo)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof DrawLotsZoneInfo.Const)) assign(((DrawLotsZoneInfo.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DrawLotsZoneInfo _o_) {
/* 564 */       this.zone = _o_.zone;
/* 565 */       this.active = _o_.active;
/* 566 */       this.mailed = _o_.mailed;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.zone = _o_.zone;
/* 572 */       this.active = _o_.active;
/* 573 */       this.mailed = _o_.mailed;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.zone);
/* 580 */       _os_.marshal(this.active);
/* 581 */       _os_.marshal(this.mailed);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.zone = _os_.unmarshal_int();
/* 589 */       this.active = _os_.unmarshal_int();
/* 590 */       this.mailed = _os_.unmarshal_int();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.zone);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.active);
/* 600 */       _size_ += CodedOutputStream.computeInt32Size(3, this.mailed);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.zone);
/* 610 */         _output_.writeInt32(2, this.active);
/* 611 */         _output_.writeInt32(3, this.mailed);
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
/* 638 */             this.zone = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.active = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.mailed = _input_.readInt32();
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
/*     */     public xbean.DrawLotsZoneInfo copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawLotsZoneInfo toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DrawLotsZoneInfo toBean()
/*     */     {
/* 687 */       return new DrawLotsZoneInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawLotsZoneInfo toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DrawLotsZoneInfo toBeanIf()
/*     */     {
/* 698 */       return new DrawLotsZoneInfo(this, null, null);
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
/*     */     public int getZone()
/*     */     {
/* 735 */       return this.zone;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActive()
/*     */     {
/* 742 */       return this.active;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMailed()
/*     */     {
/* 749 */       return this.mailed;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZone(int _v_)
/*     */     {
/* 756 */       this.zone = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActive(int _v_)
/*     */     {
/* 763 */       this.active = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMailed(int _v_)
/*     */     {
/* 770 */       this.mailed = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.zone != _o_.zone) return false;
/* 779 */       if (this.active != _o_.active) return false;
/* 780 */       if (this.mailed != _o_.mailed) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.zone;
/* 789 */       _h_ += this.active;
/* 790 */       _h_ += this.mailed;
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.zone);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.active);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.mailed);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DrawLotsZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */