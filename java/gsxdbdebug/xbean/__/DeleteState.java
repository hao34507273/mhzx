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
/*     */ public final class DeleteState extends XBean implements xbean.DeleteState
/*     */ {
/*     */   private int deletestate;
/*     */   private long deleteendtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.deletestate = 0;
/*  21 */     this.deleteendtime = 0L;
/*     */   }
/*     */   
/*     */   DeleteState(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.deletestate = 0;
/*  28 */     this.deleteendtime = 0L;
/*     */   }
/*     */   
/*     */   public DeleteState()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DeleteState(DeleteState _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DeleteState(xbean.DeleteState _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof DeleteState)) { assign((DeleteState)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DeleteState _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.deletestate = _o_.deletestate;
/*  54 */     this.deleteendtime = _o_.deleteendtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.deletestate = _o_.deletestate;
/*  60 */     this.deleteendtime = _o_.deleteendtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.deletestate);
/*  68 */     _os_.marshal(this.deleteendtime);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.deletestate = _os_.unmarshal_int();
/*  77 */     this.deleteendtime = _os_.unmarshal_long();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt32Size(1, this.deletestate);
/*  87 */     _size_ += CodedOutputStream.computeInt64Size(2, this.deleteendtime);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt32(1, this.deletestate);
/*  98 */       _output_.writeInt64(2, this.deleteendtime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 102 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 104 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       boolean done = false;
/* 114 */       while (!done)
/*     */       {
/* 116 */         int tag = _input_.readTag();
/* 117 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 121 */           done = true;
/* 122 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 126 */           this.deletestate = _input_.readInt32();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.deleteendtime = _input_.readInt64();
/* 132 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 136 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 138 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 147 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DeleteState copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new DeleteState(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DeleteState toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DeleteState toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new DeleteState(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DeleteState toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DeleteState toBeanIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDeletestate()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.deletestate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getDeleteendtime()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.deleteendtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDeletestate(int _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "deletestate")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new xdb.logs.LogInt(this, DeleteState.this.deletestate)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             DeleteState.this.deletestate = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.deletestate = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDeleteendtime(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "deleteendtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogLong(this, DeleteState.this.deleteendtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             DeleteState.this.deleteendtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.deleteendtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     DeleteState _o_ = null;
/* 259 */     if ((_o1_ instanceof DeleteState)) { _o_ = (DeleteState)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.deletestate != _o_.deletestate) return false;
/* 263 */     if (this.deleteendtime != _o_.deleteendtime) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ += this.deletestate;
/* 273 */     _h_ = (int)(_h_ + this.deleteendtime);
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.deletestate);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.deleteendtime);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     ListenableBean lb = new ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("deletestate"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("deleteendtime"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DeleteState {
/*     */     private Const() {}
/*     */     
/*     */     DeleteState nThis() {
/* 303 */       return DeleteState.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DeleteState copy()
/*     */     {
/* 315 */       return DeleteState.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DeleteState toData()
/*     */     {
/* 321 */       return DeleteState.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DeleteState toBean()
/*     */     {
/* 326 */       return DeleteState.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DeleteState toDataIf()
/*     */     {
/* 332 */       return DeleteState.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DeleteState toBeanIf()
/*     */     {
/* 337 */       return DeleteState.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDeletestate()
/*     */     {
/* 344 */       DeleteState.this._xdb_verify_unsafe_();
/* 345 */       return DeleteState.this.deletestate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDeleteendtime()
/*     */     {
/* 352 */       DeleteState.this._xdb_verify_unsafe_();
/* 353 */       return DeleteState.this.deleteendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDeletestate(int _v_)
/*     */     {
/* 360 */       DeleteState.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDeleteendtime(long _v_)
/*     */     {
/* 368 */       DeleteState.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       DeleteState.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       DeleteState.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return DeleteState.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return DeleteState.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       DeleteState.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return DeleteState.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return DeleteState.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       DeleteState.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return DeleteState.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return DeleteState.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return DeleteState.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return DeleteState.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return DeleteState.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return DeleteState.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return DeleteState.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DeleteState
/*     */   {
/*     */     private int deletestate;
/*     */     
/*     */     private long deleteendtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.deletestate = 0;
/* 483 */       this.deleteendtime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.DeleteState _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof DeleteState)) { assign((DeleteState)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof DeleteState.Const)) assign(((DeleteState.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DeleteState _o_) {
/* 496 */       this.deletestate = _o_.deletestate;
/* 497 */       this.deleteendtime = _o_.deleteendtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.deletestate = _o_.deletestate;
/* 503 */       this.deleteendtime = _o_.deleteendtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.deletestate);
/* 510 */       _os_.marshal(this.deleteendtime);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.deletestate = _os_.unmarshal_int();
/* 518 */       this.deleteendtime = _os_.unmarshal_long();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt32Size(1, this.deletestate);
/* 527 */       _size_ += CodedOutputStream.computeInt64Size(2, this.deleteendtime);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt32(1, this.deletestate);
/* 537 */         _output_.writeInt64(2, this.deleteendtime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 551 */         boolean done = false;
/* 552 */         while (!done)
/*     */         {
/* 554 */           int tag = _input_.readTag();
/* 555 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 559 */             done = true;
/* 560 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 564 */             this.deletestate = _input_.readInt32();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.deleteendtime = _input_.readInt64();
/* 570 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 574 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 576 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 585 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 589 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 591 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DeleteState copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DeleteState toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DeleteState toBean()
/*     */     {
/* 608 */       return new DeleteState(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DeleteState toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DeleteState toBeanIf()
/*     */     {
/* 619 */       return new DeleteState(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 641 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 645 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 649 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDeletestate()
/*     */     {
/* 656 */       return this.deletestate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDeleteendtime()
/*     */     {
/* 663 */       return this.deleteendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDeletestate(int _v_)
/*     */     {
/* 670 */       this.deletestate = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDeleteendtime(long _v_)
/*     */     {
/* 677 */       this.deleteendtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.deletestate != _o_.deletestate) return false;
/* 686 */       if (this.deleteendtime != _o_.deleteendtime) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ += this.deletestate;
/* 695 */       _h_ = (int)(_h_ + this.deleteendtime);
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.deletestate);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.deleteendtime);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DeleteState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */