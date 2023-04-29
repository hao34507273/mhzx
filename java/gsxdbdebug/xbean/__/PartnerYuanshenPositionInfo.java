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
/*     */ public final class PartnerYuanshenPositionInfo extends XBean implements xbean.PartnerYuanshenPositionInfo
/*     */ {
/*     */   private int attached_partner_id;
/*     */   private int level;
/*     */   private int property_num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.attached_partner_id = 0;
/*  23 */     this.level = 1;
/*  24 */     this.property_num = 0;
/*     */   }
/*     */   
/*     */   PartnerYuanshenPositionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.level = 1;
/*     */   }
/*     */   
/*     */   public PartnerYuanshenPositionInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PartnerYuanshenPositionInfo(PartnerYuanshenPositionInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PartnerYuanshenPositionInfo(xbean.PartnerYuanshenPositionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof PartnerYuanshenPositionInfo)) { assign((PartnerYuanshenPositionInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PartnerYuanshenPositionInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.attached_partner_id = _o_.attached_partner_id;
/*  56 */     this.level = _o_.level;
/*  57 */     this.property_num = _o_.property_num;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.attached_partner_id = _o_.attached_partner_id;
/*  63 */     this.level = _o_.level;
/*  64 */     this.property_num = _o_.property_num;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.attached_partner_id);
/*  72 */     _os_.marshal(this.level);
/*  73 */     _os_.marshal(this.property_num);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.attached_partner_id = _os_.unmarshal_int();
/*  82 */     this.level = _os_.unmarshal_int();
/*  83 */     this.property_num = _os_.unmarshal_int();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(1, this.attached_partner_id);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(3, this.property_num);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt32(1, this.attached_partner_id);
/* 105 */       _output_.writeInt32(2, this.level);
/* 106 */       _output_.writeInt32(3, this.property_num);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.attached_partner_id = _input_.readInt32();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.level = _input_.readInt32();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.property_num = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PartnerYuanshenPositionInfo copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new PartnerYuanshenPositionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PartnerYuanshenPositionInfo toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PartnerYuanshenPositionInfo toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new PartnerYuanshenPositionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PartnerYuanshenPositionInfo toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PartnerYuanshenPositionInfo toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAttached_partner_id()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.attached_partner_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getProperty_num()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.property_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAttached_partner_id(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "attached_partner_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new LogInt(this, PartnerYuanshenPositionInfo.this.attached_partner_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             PartnerYuanshenPositionInfo.this.attached_partner_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.attached_partner_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, PartnerYuanshenPositionInfo.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             PartnerYuanshenPositionInfo.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProperty_num(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "property_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, PartnerYuanshenPositionInfo.this.property_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             PartnerYuanshenPositionInfo.this.property_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.property_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     PartnerYuanshenPositionInfo _o_ = null;
/* 301 */     if ((_o1_ instanceof PartnerYuanshenPositionInfo)) { _o_ = (PartnerYuanshenPositionInfo)_o1_;
/* 302 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 303 */       return false;
/* 304 */     if (this.attached_partner_id != _o_.attached_partner_id) return false;
/* 305 */     if (this.level != _o_.level) return false;
/* 306 */     if (this.property_num != _o_.property_num) return false;
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     int _h_ = 0;
/* 315 */     _h_ += this.attached_partner_id;
/* 316 */     _h_ += this.level;
/* 317 */     _h_ += this.property_num;
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.attached_partner_id);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.level);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.property_num);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("attached_partner_id"));
/* 341 */     lb.add(new ListenableChanged().setVarName("level"));
/* 342 */     lb.add(new ListenableChanged().setVarName("property_num"));
/* 343 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PartnerYuanshenPositionInfo {
/*     */     private Const() {}
/*     */     
/*     */     PartnerYuanshenPositionInfo nThis() {
/* 350 */       return PartnerYuanshenPositionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerYuanshenPositionInfo copy()
/*     */     {
/* 362 */       return PartnerYuanshenPositionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerYuanshenPositionInfo toData()
/*     */     {
/* 368 */       return PartnerYuanshenPositionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PartnerYuanshenPositionInfo toBean()
/*     */     {
/* 373 */       return PartnerYuanshenPositionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerYuanshenPositionInfo toDataIf()
/*     */     {
/* 379 */       return PartnerYuanshenPositionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PartnerYuanshenPositionInfo toBeanIf()
/*     */     {
/* 384 */       return PartnerYuanshenPositionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAttached_partner_id()
/*     */     {
/* 391 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 392 */       return PartnerYuanshenPositionInfo.this.attached_partner_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 399 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 400 */       return PartnerYuanshenPositionInfo.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProperty_num()
/*     */     {
/* 407 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 408 */       return PartnerYuanshenPositionInfo.this.property_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAttached_partner_id(int _v_)
/*     */     {
/* 415 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 423 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProperty_num(int _v_)
/*     */     {
/* 431 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 438 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 439 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 445 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 446 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 452 */       return PartnerYuanshenPositionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 458 */       return PartnerYuanshenPositionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 471 */       return PartnerYuanshenPositionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 477 */       return PartnerYuanshenPositionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 483 */       PartnerYuanshenPositionInfo.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 490 */       return PartnerYuanshenPositionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 496 */       return PartnerYuanshenPositionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 502 */       return PartnerYuanshenPositionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 508 */       return PartnerYuanshenPositionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 514 */       return PartnerYuanshenPositionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 520 */       return PartnerYuanshenPositionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 526 */       return PartnerYuanshenPositionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PartnerYuanshenPositionInfo
/*     */   {
/*     */     private int attached_partner_id;
/*     */     
/*     */     private int level;
/*     */     
/*     */     private int property_num;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 547 */       this.level = 1;
/*     */     }
/*     */     
/*     */     Data(xbean.PartnerYuanshenPositionInfo _o1_)
/*     */     {
/* 552 */       if ((_o1_ instanceof PartnerYuanshenPositionInfo)) { assign((PartnerYuanshenPositionInfo)_o1_);
/* 553 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 554 */       } else if ((_o1_ instanceof PartnerYuanshenPositionInfo.Const)) assign(((PartnerYuanshenPositionInfo.Const)_o1_).nThis()); else {
/* 555 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PartnerYuanshenPositionInfo _o_) {
/* 560 */       this.attached_partner_id = _o_.attached_partner_id;
/* 561 */       this.level = _o_.level;
/* 562 */       this.property_num = _o_.property_num;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 567 */       this.attached_partner_id = _o_.attached_partner_id;
/* 568 */       this.level = _o_.level;
/* 569 */       this.property_num = _o_.property_num;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 575 */       _os_.marshal(this.attached_partner_id);
/* 576 */       _os_.marshal(this.level);
/* 577 */       _os_.marshal(this.property_num);
/* 578 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 584 */       this.attached_partner_id = _os_.unmarshal_int();
/* 585 */       this.level = _os_.unmarshal_int();
/* 586 */       this.property_num = _os_.unmarshal_int();
/* 587 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 593 */       int _size_ = 0;
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(1, this.attached_partner_id);
/* 595 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 596 */       _size_ += CodedOutputStream.computeInt32Size(3, this.property_num);
/* 597 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 605 */         _output_.writeInt32(1, this.attached_partner_id);
/* 606 */         _output_.writeInt32(2, this.level);
/* 607 */         _output_.writeInt32(3, this.property_num);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 634 */             this.attached_partner_id = _input_.readInt32();
/* 635 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 639 */             this.level = _input_.readInt32();
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.property_num = _input_.readInt32();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerYuanshenPositionInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerYuanshenPositionInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PartnerYuanshenPositionInfo toBean()
/*     */     {
/* 683 */       return new PartnerYuanshenPositionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerYuanshenPositionInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PartnerYuanshenPositionInfo toBeanIf()
/*     */     {
/* 694 */       return new PartnerYuanshenPositionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAttached_partner_id()
/*     */     {
/* 731 */       return this.attached_partner_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 738 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProperty_num()
/*     */     {
/* 745 */       return this.property_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAttached_partner_id(int _v_)
/*     */     {
/* 752 */       this.attached_partner_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 759 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProperty_num(int _v_)
/*     */     {
/* 766 */       this.property_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 772 */       if (!(_o1_ instanceof Data)) return false;
/* 773 */       Data _o_ = (Data)_o1_;
/* 774 */       if (this.attached_partner_id != _o_.attached_partner_id) return false;
/* 775 */       if (this.level != _o_.level) return false;
/* 776 */       if (this.property_num != _o_.property_num) return false;
/* 777 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 783 */       int _h_ = 0;
/* 784 */       _h_ += this.attached_partner_id;
/* 785 */       _h_ += this.level;
/* 786 */       _h_ += this.property_num;
/* 787 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 793 */       StringBuilder _sb_ = new StringBuilder();
/* 794 */       _sb_.append("(");
/* 795 */       _sb_.append(this.attached_partner_id);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.level);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.property_num);
/* 800 */       _sb_.append(")");
/* 801 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PartnerYuanshenPositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */