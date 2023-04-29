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
/*     */ public final class RoleResourcePointInfo extends XBean implements xbean.RoleResourcePointInfo
/*     */ {
/*     */   private int resource_point;
/*     */   private int add_resource_sum;
/*     */   private boolean is_in_field;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.resource_point = 0;
/*  23 */     this.add_resource_sum = 0;
/*  24 */     this.is_in_field = true;
/*     */   }
/*     */   
/*     */   RoleResourcePointInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.resource_point = 0;
/*  31 */     this.add_resource_sum = 0;
/*  32 */     this.is_in_field = true;
/*     */   }
/*     */   
/*     */   public RoleResourcePointInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleResourcePointInfo(RoleResourcePointInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleResourcePointInfo(xbean.RoleResourcePointInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof RoleResourcePointInfo)) { assign((RoleResourcePointInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleResourcePointInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.resource_point = _o_.resource_point;
/*  58 */     this.add_resource_sum = _o_.add_resource_sum;
/*  59 */     this.is_in_field = _o_.is_in_field;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.resource_point = _o_.resource_point;
/*  65 */     this.add_resource_sum = _o_.add_resource_sum;
/*  66 */     this.is_in_field = _o_.is_in_field;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.resource_point);
/*  74 */     _os_.marshal(this.add_resource_sum);
/*  75 */     _os_.marshal(this.is_in_field);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.resource_point = _os_.unmarshal_int();
/*  84 */     this.add_resource_sum = _os_.unmarshal_int();
/*  85 */     this.is_in_field = _os_.unmarshal_boolean();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.resource_point);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.add_resource_sum);
/*  96 */     _size_ += CodedOutputStream.computeBoolSize(3, this.is_in_field);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.resource_point);
/* 107 */       _output_.writeInt32(2, this.add_resource_sum);
/* 108 */       _output_.writeBool(3, this.is_in_field);
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
/* 136 */           this.resource_point = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.add_resource_sum = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.is_in_field = _input_.readBool();
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
/*     */   public xbean.RoleResourcePointInfo copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new RoleResourcePointInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleResourcePointInfo toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleResourcePointInfo toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new RoleResourcePointInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleResourcePointInfo toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleResourcePointInfo toBeanIf()
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
/*     */   public int getResource_point()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.resource_point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAdd_resource_sum()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.add_resource_sum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_in_field()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.is_in_field;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setResource_point(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "resource_point")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new xdb.logs.LogInt(this, RoleResourcePointInfo.this.resource_point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             RoleResourcePointInfo.this.resource_point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.resource_point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAdd_resource_sum(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "add_resource_sum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogInt(this, RoleResourcePointInfo.this.add_resource_sum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             RoleResourcePointInfo.this.add_resource_sum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.add_resource_sum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_in_field(boolean _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "is_in_field")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new xdb.logs.LogObject(this, Boolean.valueOf(RoleResourcePointInfo.this.is_in_field))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             RoleResourcePointInfo.this.is_in_field = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.is_in_field = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     RoleResourcePointInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof RoleResourcePointInfo)) { _o_ = (RoleResourcePointInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.resource_point != _o_.resource_point) return false;
/* 307 */     if (this.add_resource_sum != _o_.add_resource_sum) return false;
/* 308 */     if (this.is_in_field != _o_.is_in_field) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.resource_point;
/* 318 */     _h_ += this.add_resource_sum;
/* 319 */     _h_ += (this.is_in_field ? 1231 : 1237);
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.resource_point);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.add_resource_sum);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.is_in_field);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("resource_point"));
/* 343 */     lb.add(new ListenableChanged().setVarName("add_resource_sum"));
/* 344 */     lb.add(new ListenableChanged().setVarName("is_in_field"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleResourcePointInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleResourcePointInfo nThis() {
/* 352 */       return RoleResourcePointInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleResourcePointInfo copy()
/*     */     {
/* 364 */       return RoleResourcePointInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleResourcePointInfo toData()
/*     */     {
/* 370 */       return RoleResourcePointInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleResourcePointInfo toBean()
/*     */     {
/* 375 */       return RoleResourcePointInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleResourcePointInfo toDataIf()
/*     */     {
/* 381 */       return RoleResourcePointInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleResourcePointInfo toBeanIf()
/*     */     {
/* 386 */       return RoleResourcePointInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getResource_point()
/*     */     {
/* 393 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 394 */       return RoleResourcePointInfo.this.resource_point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAdd_resource_sum()
/*     */     {
/* 401 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 402 */       return RoleResourcePointInfo.this.add_resource_sum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_in_field()
/*     */     {
/* 409 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 410 */       return RoleResourcePointInfo.this.is_in_field;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setResource_point(int _v_)
/*     */     {
/* 417 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAdd_resource_sum(int _v_)
/*     */     {
/* 425 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_in_field(boolean _v_)
/*     */     {
/* 433 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 440 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return RoleResourcePointInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return RoleResourcePointInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return RoleResourcePointInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return RoleResourcePointInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       RoleResourcePointInfo.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 492 */       return RoleResourcePointInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return RoleResourcePointInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return RoleResourcePointInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return RoleResourcePointInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return RoleResourcePointInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return RoleResourcePointInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return RoleResourcePointInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleResourcePointInfo
/*     */   {
/*     */     private int resource_point;
/*     */     
/*     */     private int add_resource_sum;
/*     */     
/*     */     private boolean is_in_field;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.resource_point = 0;
/* 550 */       this.add_resource_sum = 0;
/* 551 */       this.is_in_field = true;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleResourcePointInfo _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof RoleResourcePointInfo)) { assign((RoleResourcePointInfo)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof RoleResourcePointInfo.Const)) assign(((RoleResourcePointInfo.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleResourcePointInfo _o_) {
/* 564 */       this.resource_point = _o_.resource_point;
/* 565 */       this.add_resource_sum = _o_.add_resource_sum;
/* 566 */       this.is_in_field = _o_.is_in_field;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.resource_point = _o_.resource_point;
/* 572 */       this.add_resource_sum = _o_.add_resource_sum;
/* 573 */       this.is_in_field = _o_.is_in_field;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.resource_point);
/* 580 */       _os_.marshal(this.add_resource_sum);
/* 581 */       _os_.marshal(this.is_in_field);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.resource_point = _os_.unmarshal_int();
/* 589 */       this.add_resource_sum = _os_.unmarshal_int();
/* 590 */       this.is_in_field = _os_.unmarshal_boolean();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.resource_point);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.add_resource_sum);
/* 600 */       _size_ += CodedOutputStream.computeBoolSize(3, this.is_in_field);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.resource_point);
/* 610 */         _output_.writeInt32(2, this.add_resource_sum);
/* 611 */         _output_.writeBool(3, this.is_in_field);
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
/* 638 */             this.resource_point = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.add_resource_sum = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.is_in_field = _input_.readBool();
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
/*     */     public xbean.RoleResourcePointInfo copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleResourcePointInfo toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleResourcePointInfo toBean()
/*     */     {
/* 687 */       return new RoleResourcePointInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleResourcePointInfo toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleResourcePointInfo toBeanIf()
/*     */     {
/* 698 */       return new RoleResourcePointInfo(this, null, null);
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
/*     */     public int getResource_point()
/*     */     {
/* 735 */       return this.resource_point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAdd_resource_sum()
/*     */     {
/* 742 */       return this.add_resource_sum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_in_field()
/*     */     {
/* 749 */       return this.is_in_field;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setResource_point(int _v_)
/*     */     {
/* 756 */       this.resource_point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAdd_resource_sum(int _v_)
/*     */     {
/* 763 */       this.add_resource_sum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_in_field(boolean _v_)
/*     */     {
/* 770 */       this.is_in_field = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.resource_point != _o_.resource_point) return false;
/* 779 */       if (this.add_resource_sum != _o_.add_resource_sum) return false;
/* 780 */       if (this.is_in_field != _o_.is_in_field) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.resource_point;
/* 789 */       _h_ += this.add_resource_sum;
/* 790 */       _h_ += (this.is_in_field ? 1231 : 1237);
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.resource_point);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.add_resource_sum);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.is_in_field);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleResourcePointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */