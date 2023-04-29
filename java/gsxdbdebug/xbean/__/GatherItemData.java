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
/*     */ public final class GatherItemData extends XBean implements xbean.GatherItemData
/*     */ {
/*     */   private int gathercfgid;
/*     */   private boolean gathering;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.gathercfgid = 0;
/*  21 */     this.gathering = false;
/*     */   }
/*     */   
/*     */   GatherItemData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.gathering = false;
/*     */   }
/*     */   
/*     */   public GatherItemData()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GatherItemData(GatherItemData _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GatherItemData(xbean.GatherItemData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof GatherItemData)) { assign((GatherItemData)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GatherItemData _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.gathercfgid = _o_.gathercfgid;
/*  53 */     this.gathering = _o_.gathering;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.gathercfgid = _o_.gathercfgid;
/*  59 */     this.gathering = _o_.gathering;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.gathercfgid);
/*  67 */     _os_.marshal(this.gathering);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.gathercfgid = _os_.unmarshal_int();
/*  76 */     this.gathering = _os_.unmarshal_boolean();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(1, this.gathercfgid);
/*  86 */     _size_ += CodedOutputStream.computeBoolSize(2, this.gathering);
/*  87 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  96 */       _output_.writeInt32(1, this.gathercfgid);
/*  97 */       _output_.writeBool(2, this.gathering);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 101 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 103 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       boolean done = false;
/* 113 */       while (!done)
/*     */       {
/* 115 */         int tag = _input_.readTag();
/* 116 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 120 */           done = true;
/* 121 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 125 */           this.gathercfgid = _input_.readInt32();
/* 126 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 130 */           this.gathering = _input_.readBool();
/* 131 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 135 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 137 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 146 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GatherItemData copy()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new GatherItemData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GatherItemData toData()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GatherItemData toBean()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new GatherItemData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GatherItemData toDataIf()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GatherItemData toBeanIf()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGathercfgid()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this.gathercfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getGathering()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this.gathering;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGathercfgid(int _v_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     xdb.Logs.logIf(new LogKey(this, "gathercfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 220 */         new xdb.logs.LogInt(this, GatherItemData.this.gathercfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 224 */             GatherItemData.this.gathercfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 228 */     });
/* 229 */     this.gathercfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGathering(boolean _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "gathering")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogObject(this, Boolean.valueOf(GatherItemData.this.gathering))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             GatherItemData.this.gathering = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.gathering = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     GatherItemData _o_ = null;
/* 258 */     if ((_o1_ instanceof GatherItemData)) { _o_ = (GatherItemData)_o1_;
/* 259 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 260 */       return false;
/* 261 */     if (this.gathercfgid != _o_.gathercfgid) return false;
/* 262 */     if (this.gathering != _o_.gathering) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ += this.gathercfgid;
/* 272 */     _h_ += (this.gathering ? 1231 : 1237);
/* 273 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     StringBuilder _sb_ = new StringBuilder();
/* 281 */     _sb_.append("(");
/* 282 */     _sb_.append(this.gathercfgid);
/* 283 */     _sb_.append(",");
/* 284 */     _sb_.append(this.gathering);
/* 285 */     _sb_.append(")");
/* 286 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 292 */     ListenableBean lb = new ListenableBean();
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gathercfgid"));
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gathering"));
/* 295 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GatherItemData {
/*     */     private Const() {}
/*     */     
/*     */     GatherItemData nThis() {
/* 302 */       return GatherItemData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherItemData copy()
/*     */     {
/* 314 */       return GatherItemData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherItemData toData()
/*     */     {
/* 320 */       return GatherItemData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GatherItemData toBean()
/*     */     {
/* 325 */       return GatherItemData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherItemData toDataIf()
/*     */     {
/* 331 */       return GatherItemData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GatherItemData toBeanIf()
/*     */     {
/* 336 */       return GatherItemData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGathercfgid()
/*     */     {
/* 343 */       GatherItemData.this._xdb_verify_unsafe_();
/* 344 */       return GatherItemData.this.gathercfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getGathering()
/*     */     {
/* 351 */       GatherItemData.this._xdb_verify_unsafe_();
/* 352 */       return GatherItemData.this.gathering;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGathercfgid(int _v_)
/*     */     {
/* 359 */       GatherItemData.this._xdb_verify_unsafe_();
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGathering(boolean _v_)
/*     */     {
/* 367 */       GatherItemData.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 374 */       GatherItemData.this._xdb_verify_unsafe_();
/* 375 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 381 */       GatherItemData.this._xdb_verify_unsafe_();
/* 382 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 388 */       return GatherItemData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 394 */       return GatherItemData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 400 */       GatherItemData.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 407 */       return GatherItemData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       return GatherItemData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 419 */       GatherItemData.this._xdb_verify_unsafe_();
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 426 */       return GatherItemData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 432 */       return GatherItemData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 438 */       return GatherItemData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 444 */       return GatherItemData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 450 */       return GatherItemData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 456 */       return GatherItemData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 462 */       return GatherItemData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GatherItemData
/*     */   {
/*     */     private int gathercfgid;
/*     */     
/*     */     private boolean gathering;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 481 */       this.gathering = false;
/*     */     }
/*     */     
/*     */     Data(xbean.GatherItemData _o1_)
/*     */     {
/* 486 */       if ((_o1_ instanceof GatherItemData)) { assign((GatherItemData)_o1_);
/* 487 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 488 */       } else if ((_o1_ instanceof GatherItemData.Const)) assign(((GatherItemData.Const)_o1_).nThis()); else {
/* 489 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GatherItemData _o_) {
/* 494 */       this.gathercfgid = _o_.gathercfgid;
/* 495 */       this.gathering = _o_.gathering;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 500 */       this.gathercfgid = _o_.gathercfgid;
/* 501 */       this.gathering = _o_.gathering;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.gathercfgid);
/* 508 */       _os_.marshal(this.gathering);
/* 509 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       this.gathercfgid = _os_.unmarshal_int();
/* 516 */       this.gathering = _os_.unmarshal_boolean();
/* 517 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 523 */       int _size_ = 0;
/* 524 */       _size_ += CodedOutputStream.computeInt32Size(1, this.gathercfgid);
/* 525 */       _size_ += CodedOutputStream.computeBoolSize(2, this.gathering);
/* 526 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         _output_.writeInt32(1, this.gathercfgid);
/* 535 */         _output_.writeBool(2, this.gathering);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 539 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 541 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 549 */         boolean done = false;
/* 550 */         while (!done)
/*     */         {
/* 552 */           int tag = _input_.readTag();
/* 553 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 557 */             done = true;
/* 558 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 562 */             this.gathercfgid = _input_.readInt32();
/* 563 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 567 */             this.gathering = _input_.readBool();
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherItemData copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherItemData toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GatherItemData toBean()
/*     */     {
/* 606 */       return new GatherItemData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GatherItemData toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GatherItemData toBeanIf()
/*     */     {
/* 617 */       return new GatherItemData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGathercfgid()
/*     */     {
/* 654 */       return this.gathercfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getGathering()
/*     */     {
/* 661 */       return this.gathering;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGathercfgid(int _v_)
/*     */     {
/* 668 */       this.gathercfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGathering(boolean _v_)
/*     */     {
/* 675 */       this.gathering = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (this.gathercfgid != _o_.gathercfgid) return false;
/* 684 */       if (this.gathering != _o_.gathering) return false;
/* 685 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 691 */       int _h_ = 0;
/* 692 */       _h_ += this.gathercfgid;
/* 693 */       _h_ += (this.gathering ? 1231 : 1237);
/* 694 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 700 */       StringBuilder _sb_ = new StringBuilder();
/* 701 */       _sb_.append("(");
/* 702 */       _sb_.append(this.gathercfgid);
/* 703 */       _sb_.append(",");
/* 704 */       _sb_.append(this.gathering);
/* 705 */       _sb_.append(")");
/* 706 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GatherItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */