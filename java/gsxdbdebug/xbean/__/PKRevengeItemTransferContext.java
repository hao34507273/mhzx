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
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class PKRevengeItemTransferContext extends XBean implements xbean.PKRevengeItemTransferContext
/*     */ {
/*     */   private int map_id;
/*     */   private int pos_x;
/*     */   private int pos_y;
/*     */   private long session_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.map_id = 0;
/*  25 */     this.pos_x = 0;
/*  26 */     this.pos_y = 0;
/*  27 */     this.session_id = 0L;
/*     */   }
/*     */   
/*     */   PKRevengeItemTransferContext(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public PKRevengeItemTransferContext()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PKRevengeItemTransferContext(PKRevengeItemTransferContext _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PKRevengeItemTransferContext(xbean.PKRevengeItemTransferContext _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof PKRevengeItemTransferContext)) { assign((PKRevengeItemTransferContext)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PKRevengeItemTransferContext _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.map_id = _o_.map_id;
/*  58 */     this.pos_x = _o_.pos_x;
/*  59 */     this.pos_y = _o_.pos_y;
/*  60 */     this.session_id = _o_.session_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.map_id = _o_.map_id;
/*  66 */     this.pos_x = _o_.pos_x;
/*  67 */     this.pos_y = _o_.pos_y;
/*  68 */     this.session_id = _o_.session_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.map_id);
/*  76 */     _os_.marshal(this.pos_x);
/*  77 */     _os_.marshal(this.pos_y);
/*  78 */     _os_.marshal(this.session_id);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.map_id = _os_.unmarshal_int();
/*  87 */     this.pos_x = _os_.unmarshal_int();
/*  88 */     this.pos_y = _os_.unmarshal_int();
/*  89 */     this.session_id = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.map_id);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.pos_x);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.pos_y);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.session_id);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.map_id);
/* 112 */       _output_.writeInt32(2, this.pos_x);
/* 113 */       _output_.writeInt32(3, this.pos_y);
/* 114 */       _output_.writeInt64(4, this.session_id);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.map_id = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.pos_x = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.pos_y = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.session_id = _input_.readInt64();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PKRevengeItemTransferContext copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new PKRevengeItemTransferContext(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PKRevengeItemTransferContext toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PKRevengeItemTransferContext toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new PKRevengeItemTransferContext(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PKRevengeItemTransferContext toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PKRevengeItemTransferContext toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMap_id()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.map_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPos_x()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.pos_x;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPos_y()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.pos_y;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSession_id()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMap_id(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "map_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, PKRevengeItemTransferContext.this.map_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             PKRevengeItemTransferContext.this.map_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.map_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPos_x(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "pos_x")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, PKRevengeItemTransferContext.this.pos_x)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             PKRevengeItemTransferContext.this.pos_x = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.pos_x = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPos_y(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "pos_y")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogInt(this, PKRevengeItemTransferContext.this.pos_y)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             PKRevengeItemTransferContext.this.pos_y = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.pos_y = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSession_id(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, PKRevengeItemTransferContext.this.session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             PKRevengeItemTransferContext.this.session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     PKRevengeItemTransferContext _o_ = null;
/* 343 */     if ((_o1_ instanceof PKRevengeItemTransferContext)) { _o_ = (PKRevengeItemTransferContext)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.map_id != _o_.map_id) return false;
/* 347 */     if (this.pos_x != _o_.pos_x) return false;
/* 348 */     if (this.pos_y != _o_.pos_y) return false;
/* 349 */     if (this.session_id != _o_.session_id) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.map_id;
/* 359 */     _h_ += this.pos_x;
/* 360 */     _h_ += this.pos_y;
/* 361 */     _h_ = (int)(_h_ + this.session_id);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.map_id);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.pos_x);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.pos_y);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.session_id);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("map_id"));
/* 387 */     lb.add(new ListenableChanged().setVarName("pos_x"));
/* 388 */     lb.add(new ListenableChanged().setVarName("pos_y"));
/* 389 */     lb.add(new ListenableChanged().setVarName("session_id"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PKRevengeItemTransferContext {
/*     */     private Const() {}
/*     */     
/*     */     PKRevengeItemTransferContext nThis() {
/* 397 */       return PKRevengeItemTransferContext.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PKRevengeItemTransferContext copy()
/*     */     {
/* 409 */       return PKRevengeItemTransferContext.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PKRevengeItemTransferContext toData()
/*     */     {
/* 415 */       return PKRevengeItemTransferContext.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PKRevengeItemTransferContext toBean()
/*     */     {
/* 420 */       return PKRevengeItemTransferContext.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PKRevengeItemTransferContext toDataIf()
/*     */     {
/* 426 */       return PKRevengeItemTransferContext.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PKRevengeItemTransferContext toBeanIf()
/*     */     {
/* 431 */       return PKRevengeItemTransferContext.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMap_id()
/*     */     {
/* 438 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 439 */       return PKRevengeItemTransferContext.this.map_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPos_x()
/*     */     {
/* 446 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 447 */       return PKRevengeItemTransferContext.this.pos_x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPos_y()
/*     */     {
/* 454 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 455 */       return PKRevengeItemTransferContext.this.pos_y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSession_id()
/*     */     {
/* 462 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 463 */       return PKRevengeItemTransferContext.this.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMap_id(int _v_)
/*     */     {
/* 470 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPos_x(int _v_)
/*     */     {
/* 478 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPos_y(int _v_)
/*     */     {
/* 486 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession_id(long _v_)
/*     */     {
/* 494 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return PKRevengeItemTransferContext.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return PKRevengeItemTransferContext.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return PKRevengeItemTransferContext.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return PKRevengeItemTransferContext.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       PKRevengeItemTransferContext.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return PKRevengeItemTransferContext.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return PKRevengeItemTransferContext.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return PKRevengeItemTransferContext.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return PKRevengeItemTransferContext.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return PKRevengeItemTransferContext.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return PKRevengeItemTransferContext.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return PKRevengeItemTransferContext.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PKRevengeItemTransferContext
/*     */   {
/*     */     private int map_id;
/*     */     
/*     */     private int pos_x;
/*     */     
/*     */     private int pos_y;
/*     */     
/*     */     private long session_id;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.PKRevengeItemTransferContext _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof PKRevengeItemTransferContext)) { assign((PKRevengeItemTransferContext)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof PKRevengeItemTransferContext.Const)) assign(((PKRevengeItemTransferContext.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PKRevengeItemTransferContext _o_) {
/* 624 */       this.map_id = _o_.map_id;
/* 625 */       this.pos_x = _o_.pos_x;
/* 626 */       this.pos_y = _o_.pos_y;
/* 627 */       this.session_id = _o_.session_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.map_id = _o_.map_id;
/* 633 */       this.pos_x = _o_.pos_x;
/* 634 */       this.pos_y = _o_.pos_y;
/* 635 */       this.session_id = _o_.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.map_id);
/* 642 */       _os_.marshal(this.pos_x);
/* 643 */       _os_.marshal(this.pos_y);
/* 644 */       _os_.marshal(this.session_id);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.map_id = _os_.unmarshal_int();
/* 652 */       this.pos_x = _os_.unmarshal_int();
/* 653 */       this.pos_y = _os_.unmarshal_int();
/* 654 */       this.session_id = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.map_id);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.pos_x);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.pos_y);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.session_id);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.map_id);
/* 675 */         _output_.writeInt32(2, this.pos_x);
/* 676 */         _output_.writeInt32(3, this.pos_y);
/* 677 */         _output_.writeInt64(4, this.session_id);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.map_id = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.pos_x = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.pos_y = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.session_id = _input_.readInt64();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PKRevengeItemTransferContext copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PKRevengeItemTransferContext toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PKRevengeItemTransferContext toBean()
/*     */     {
/* 758 */       return new PKRevengeItemTransferContext(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PKRevengeItemTransferContext toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PKRevengeItemTransferContext toBeanIf()
/*     */     {
/* 769 */       return new PKRevengeItemTransferContext(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMap_id()
/*     */     {
/* 806 */       return this.map_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPos_x()
/*     */     {
/* 813 */       return this.pos_x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPos_y()
/*     */     {
/* 820 */       return this.pos_y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSession_id()
/*     */     {
/* 827 */       return this.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMap_id(int _v_)
/*     */     {
/* 834 */       this.map_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPos_x(int _v_)
/*     */     {
/* 841 */       this.pos_x = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPos_y(int _v_)
/*     */     {
/* 848 */       this.pos_y = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession_id(long _v_)
/*     */     {
/* 855 */       this.session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.map_id != _o_.map_id) return false;
/* 864 */       if (this.pos_x != _o_.pos_x) return false;
/* 865 */       if (this.pos_y != _o_.pos_y) return false;
/* 866 */       if (this.session_id != _o_.session_id) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.map_id;
/* 875 */       _h_ += this.pos_x;
/* 876 */       _h_ += this.pos_y;
/* 877 */       _h_ = (int)(_h_ + this.session_id);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.map_id);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.pos_x);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.pos_y);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.session_id);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PKRevengeItemTransferContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */