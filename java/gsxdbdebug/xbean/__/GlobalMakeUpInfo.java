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
/*     */ public final class GlobalMakeUpInfo extends XBean implements xbean.GlobalMakeUpInfo
/*     */ {
/*     */   private int turn;
/*     */   private boolean quetioning;
/*     */   private long preparesessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.turn = 0;
/*  23 */     this.quetioning = false;
/*  24 */     this.preparesessionid = 0L;
/*     */   }
/*     */   
/*     */   GlobalMakeUpInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public GlobalMakeUpInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GlobalMakeUpInfo(GlobalMakeUpInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GlobalMakeUpInfo(xbean.GlobalMakeUpInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof GlobalMakeUpInfo)) { assign((GlobalMakeUpInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GlobalMakeUpInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.turn = _o_.turn;
/*  55 */     this.quetioning = _o_.quetioning;
/*  56 */     this.preparesessionid = _o_.preparesessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.turn = _o_.turn;
/*  62 */     this.quetioning = _o_.quetioning;
/*  63 */     this.preparesessionid = _o_.preparesessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.turn);
/*  71 */     _os_.marshal(this.quetioning);
/*  72 */     _os_.marshal(this.preparesessionid);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.turn = _os_.unmarshal_int();
/*  81 */     this.quetioning = _os_.unmarshal_boolean();
/*  82 */     this.preparesessionid = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.turn);
/*  92 */     _size_ += CodedOutputStream.computeBoolSize(2, this.quetioning);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.preparesessionid);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.turn);
/* 104 */       _output_.writeBool(2, this.quetioning);
/* 105 */       _output_.writeInt64(3, this.preparesessionid);
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
/* 133 */           this.turn = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.quetioning = _input_.readBool();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.preparesessionid = _input_.readInt64();
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
/*     */   public xbean.GlobalMakeUpInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new GlobalMakeUpInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalMakeUpInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalMakeUpInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new GlobalMakeUpInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalMakeUpInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalMakeUpInfo toBeanIf()
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
/*     */   public int getTurn()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.turn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getQuetioning()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.quetioning;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPreparesessionid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.preparesessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTurn(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "turn")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, GlobalMakeUpInfo.this.turn)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             GlobalMakeUpInfo.this.turn = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.turn = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuetioning(boolean _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "quetioning")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogObject(this, Boolean.valueOf(GlobalMakeUpInfo.this.quetioning))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             GlobalMakeUpInfo.this.quetioning = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.quetioning = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPreparesessionid(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "preparesessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, GlobalMakeUpInfo.this.preparesessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             GlobalMakeUpInfo.this.preparesessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.preparesessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     GlobalMakeUpInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof GlobalMakeUpInfo)) { _o_ = (GlobalMakeUpInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.turn != _o_.turn) return false;
/* 304 */     if (this.quetioning != _o_.quetioning) return false;
/* 305 */     if (this.preparesessionid != _o_.preparesessionid) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.turn;
/* 315 */     _h_ += (this.quetioning ? 1231 : 1237);
/* 316 */     _h_ = (int)(_h_ + this.preparesessionid);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.turn);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.quetioning);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.preparesessionid);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("turn"));
/* 340 */     lb.add(new ListenableChanged().setVarName("quetioning"));
/* 341 */     lb.add(new ListenableChanged().setVarName("preparesessionid"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GlobalMakeUpInfo {
/*     */     private Const() {}
/*     */     
/*     */     GlobalMakeUpInfo nThis() {
/* 349 */       return GlobalMakeUpInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalMakeUpInfo copy()
/*     */     {
/* 361 */       return GlobalMakeUpInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalMakeUpInfo toData()
/*     */     {
/* 367 */       return GlobalMakeUpInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GlobalMakeUpInfo toBean()
/*     */     {
/* 372 */       return GlobalMakeUpInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalMakeUpInfo toDataIf()
/*     */     {
/* 378 */       return GlobalMakeUpInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GlobalMakeUpInfo toBeanIf()
/*     */     {
/* 383 */       return GlobalMakeUpInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTurn()
/*     */     {
/* 390 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 391 */       return GlobalMakeUpInfo.this.turn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getQuetioning()
/*     */     {
/* 398 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 399 */       return GlobalMakeUpInfo.this.quetioning;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPreparesessionid()
/*     */     {
/* 406 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 407 */       return GlobalMakeUpInfo.this.preparesessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTurn(int _v_)
/*     */     {
/* 414 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuetioning(boolean _v_)
/*     */     {
/* 422 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPreparesessionid(long _v_)
/*     */     {
/* 430 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return GlobalMakeUpInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return GlobalMakeUpInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return GlobalMakeUpInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return GlobalMakeUpInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       GlobalMakeUpInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return GlobalMakeUpInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return GlobalMakeUpInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return GlobalMakeUpInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return GlobalMakeUpInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return GlobalMakeUpInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return GlobalMakeUpInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return GlobalMakeUpInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GlobalMakeUpInfo
/*     */   {
/*     */     private int turn;
/*     */     
/*     */     private boolean quetioning;
/*     */     
/*     */     private long preparesessionid;
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
/*     */     Data(xbean.GlobalMakeUpInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof GlobalMakeUpInfo)) { assign((GlobalMakeUpInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof GlobalMakeUpInfo.Const)) assign(((GlobalMakeUpInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GlobalMakeUpInfo _o_) {
/* 558 */       this.turn = _o_.turn;
/* 559 */       this.quetioning = _o_.quetioning;
/* 560 */       this.preparesessionid = _o_.preparesessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.turn = _o_.turn;
/* 566 */       this.quetioning = _o_.quetioning;
/* 567 */       this.preparesessionid = _o_.preparesessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.turn);
/* 574 */       _os_.marshal(this.quetioning);
/* 575 */       _os_.marshal(this.preparesessionid);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.turn = _os_.unmarshal_int();
/* 583 */       this.quetioning = _os_.unmarshal_boolean();
/* 584 */       this.preparesessionid = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.turn);
/* 593 */       _size_ += CodedOutputStream.computeBoolSize(2, this.quetioning);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.preparesessionid);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.turn);
/* 604 */         _output_.writeBool(2, this.quetioning);
/* 605 */         _output_.writeInt64(3, this.preparesessionid);
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
/* 632 */             this.turn = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.quetioning = _input_.readBool();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.preparesessionid = _input_.readInt64();
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
/*     */     public xbean.GlobalMakeUpInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalMakeUpInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GlobalMakeUpInfo toBean()
/*     */     {
/* 681 */       return new GlobalMakeUpInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalMakeUpInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GlobalMakeUpInfo toBeanIf()
/*     */     {
/* 692 */       return new GlobalMakeUpInfo(this, null, null);
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
/*     */     public int getTurn()
/*     */     {
/* 729 */       return this.turn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getQuetioning()
/*     */     {
/* 736 */       return this.quetioning;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPreparesessionid()
/*     */     {
/* 743 */       return this.preparesessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTurn(int _v_)
/*     */     {
/* 750 */       this.turn = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuetioning(boolean _v_)
/*     */     {
/* 757 */       this.quetioning = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPreparesessionid(long _v_)
/*     */     {
/* 764 */       this.preparesessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.turn != _o_.turn) return false;
/* 773 */       if (this.quetioning != _o_.quetioning) return false;
/* 774 */       if (this.preparesessionid != _o_.preparesessionid) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.turn;
/* 783 */       _h_ += (this.quetioning ? 1231 : 1237);
/* 784 */       _h_ = (int)(_h_ + this.preparesessionid);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.turn);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.quetioning);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.preparesessionid);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GlobalMakeUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */