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
/*     */ public final class TargetInfo extends XBean implements xbean.TargetInfo
/*     */ {
/*     */   private int targettype;
/*     */   private int targetstate;
/*     */   private int targetparam;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.targettype = 0;
/*  23 */     this.targetstate = 0;
/*  24 */     this.targetparam = 0;
/*     */   }
/*     */   
/*     */   TargetInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public TargetInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TargetInfo(TargetInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TargetInfo(xbean.TargetInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof TargetInfo)) { assign((TargetInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TargetInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.targettype = _o_.targettype;
/*  55 */     this.targetstate = _o_.targetstate;
/*  56 */     this.targetparam = _o_.targetparam;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.targettype = _o_.targettype;
/*  62 */     this.targetstate = _o_.targetstate;
/*  63 */     this.targetparam = _o_.targetparam;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.targettype);
/*  71 */     _os_.marshal(this.targetstate);
/*  72 */     _os_.marshal(this.targetparam);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.targettype = _os_.unmarshal_int();
/*  81 */     this.targetstate = _os_.unmarshal_int();
/*  82 */     this.targetparam = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.targettype);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.targetstate);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.targetparam);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.targettype);
/* 104 */       _output_.writeInt32(2, this.targetstate);
/* 105 */       _output_.writeInt32(3, this.targetparam);
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
/* 133 */           this.targettype = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.targetstate = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.targetparam = _input_.readInt32();
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
/*     */   public xbean.TargetInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new TargetInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TargetInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TargetInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new TargetInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TargetInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TargetInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTargettype()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.targettype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTargetstate()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.targetstate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTargetparam()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.targetparam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTargettype(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "targettype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new LogInt(this, TargetInfo.this.targettype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             TargetInfo.this.targettype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.targettype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTargetstate(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "targetstate")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new LogInt(this, TargetInfo.this.targetstate)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             TargetInfo.this.targetstate = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.targetstate = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTargetparam(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "targetparam")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new LogInt(this, TargetInfo.this.targetparam)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             TargetInfo.this.targetparam = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.targetparam = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     TargetInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof TargetInfo)) { _o_ = (TargetInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.targettype != _o_.targettype) return false;
/* 304 */     if (this.targetstate != _o_.targetstate) return false;
/* 305 */     if (this.targetparam != _o_.targetparam) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.targettype;
/* 315 */     _h_ += this.targetstate;
/* 316 */     _h_ += this.targetparam;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.targettype);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.targetstate);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.targetparam);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("targettype"));
/* 340 */     lb.add(new ListenableChanged().setVarName("targetstate"));
/* 341 */     lb.add(new ListenableChanged().setVarName("targetparam"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TargetInfo {
/*     */     private Const() {}
/*     */     
/*     */     TargetInfo nThis() {
/* 349 */       return TargetInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TargetInfo copy()
/*     */     {
/* 361 */       return TargetInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TargetInfo toData()
/*     */     {
/* 367 */       return TargetInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TargetInfo toBean()
/*     */     {
/* 372 */       return TargetInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TargetInfo toDataIf()
/*     */     {
/* 378 */       return TargetInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TargetInfo toBeanIf()
/*     */     {
/* 383 */       return TargetInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTargettype()
/*     */     {
/* 390 */       TargetInfo.this._xdb_verify_unsafe_();
/* 391 */       return TargetInfo.this.targettype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTargetstate()
/*     */     {
/* 398 */       TargetInfo.this._xdb_verify_unsafe_();
/* 399 */       return TargetInfo.this.targetstate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTargetparam()
/*     */     {
/* 406 */       TargetInfo.this._xdb_verify_unsafe_();
/* 407 */       return TargetInfo.this.targetparam;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTargettype(int _v_)
/*     */     {
/* 414 */       TargetInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTargetstate(int _v_)
/*     */     {
/* 422 */       TargetInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTargetparam(int _v_)
/*     */     {
/* 430 */       TargetInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 437 */       TargetInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       TargetInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return TargetInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return TargetInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       TargetInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return TargetInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return TargetInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       TargetInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 489 */       return TargetInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return TargetInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return TargetInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return TargetInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return TargetInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return TargetInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return TargetInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TargetInfo
/*     */   {
/*     */     private int targettype;
/*     */     
/*     */     private int targetstate;
/*     */     
/*     */     private int targetparam;
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
/*     */     Data(xbean.TargetInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof TargetInfo)) { assign((TargetInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof TargetInfo.Const)) assign(((TargetInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TargetInfo _o_) {
/* 558 */       this.targettype = _o_.targettype;
/* 559 */       this.targetstate = _o_.targetstate;
/* 560 */       this.targetparam = _o_.targetparam;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.targettype = _o_.targettype;
/* 566 */       this.targetstate = _o_.targetstate;
/* 567 */       this.targetparam = _o_.targetparam;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.targettype);
/* 574 */       _os_.marshal(this.targetstate);
/* 575 */       _os_.marshal(this.targetparam);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.targettype = _os_.unmarshal_int();
/* 583 */       this.targetstate = _os_.unmarshal_int();
/* 584 */       this.targetparam = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.targettype);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.targetstate);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.targetparam);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.targettype);
/* 604 */         _output_.writeInt32(2, this.targetstate);
/* 605 */         _output_.writeInt32(3, this.targetparam);
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
/* 632 */             this.targettype = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.targetstate = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.targetparam = _input_.readInt32();
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
/*     */     public xbean.TargetInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TargetInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TargetInfo toBean()
/*     */     {
/* 681 */       return new TargetInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TargetInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TargetInfo toBeanIf()
/*     */     {
/* 692 */       return new TargetInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
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
/*     */     public xdb.Bean toConst() {
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
/*     */     public int getTargettype()
/*     */     {
/* 729 */       return this.targettype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTargetstate()
/*     */     {
/* 736 */       return this.targetstate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTargetparam()
/*     */     {
/* 743 */       return this.targetparam;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTargettype(int _v_)
/*     */     {
/* 750 */       this.targettype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTargetstate(int _v_)
/*     */     {
/* 757 */       this.targetstate = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTargetparam(int _v_)
/*     */     {
/* 764 */       this.targetparam = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.targettype != _o_.targettype) return false;
/* 773 */       if (this.targetstate != _o_.targetstate) return false;
/* 774 */       if (this.targetparam != _o_.targetparam) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.targettype;
/* 783 */       _h_ += this.targetstate;
/* 784 */       _h_ += this.targetparam;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.targettype);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.targetstate);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.targetparam);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TargetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */