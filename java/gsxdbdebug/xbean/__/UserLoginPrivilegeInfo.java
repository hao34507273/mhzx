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
/*     */ 
/*     */ public final class UserLoginPrivilegeInfo extends XBean implements xbean.UserLoginPrivilegeInfo
/*     */ {
/*     */   private long record_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.record_time = 0L;
/*     */   }
/*     */   
/*     */   UserLoginPrivilegeInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.record_time = 0L;
/*     */   }
/*     */   
/*     */   public UserLoginPrivilegeInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public UserLoginPrivilegeInfo(UserLoginPrivilegeInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   UserLoginPrivilegeInfo(xbean.UserLoginPrivilegeInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof UserLoginPrivilegeInfo)) { assign((UserLoginPrivilegeInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(UserLoginPrivilegeInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.record_time = _o_.record_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  54 */     this.record_time = _o_.record_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _xdb_verify_unsafe_();
/*  61 */     _os_.marshal(this.record_time);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     this.record_time = _os_.unmarshal_long();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     int _size_ = 0;
/*  78 */     _size_ += CodedOutputStream.computeInt64Size(1, this.record_time);
/*  79 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  88 */       _output_.writeInt64(1, this.record_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  92 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/*  94 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       boolean done = false;
/* 104 */       while (!done)
/*     */       {
/* 106 */         int tag = _input_.readTag();
/* 107 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 111 */           done = true;
/* 112 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 116 */           this.record_time = _input_.readInt64();
/* 117 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 121 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 123 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 132 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.UserLoginPrivilegeInfo copy()
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/* 145 */     return new UserLoginPrivilegeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.UserLoginPrivilegeInfo toData()
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/* 152 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.UserLoginPrivilegeInfo toBean()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new UserLoginPrivilegeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.UserLoginPrivilegeInfo toDataIf()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.UserLoginPrivilegeInfo toBeanIf()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRecord_time()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this.record_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRecord_time(long _v_)
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     xdb.Logs.logIf(new LogKey(this, "record_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 198 */         new xdb.logs.LogLong(this, UserLoginPrivilegeInfo.this.record_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 202 */             UserLoginPrivilegeInfo.this.record_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 206 */     });
/* 207 */     this.record_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     UserLoginPrivilegeInfo _o_ = null;
/* 215 */     if ((_o1_ instanceof UserLoginPrivilegeInfo)) { _o_ = (UserLoginPrivilegeInfo)_o1_;
/* 216 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 217 */       return false;
/* 218 */     if (this.record_time != _o_.record_time) return false;
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     int _h_ = 0;
/* 227 */     _h_ = (int)(_h_ + this.record_time);
/* 228 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     StringBuilder _sb_ = new StringBuilder();
/* 236 */     _sb_.append("(");
/* 237 */     _sb_.append(this.record_time);
/* 238 */     _sb_.append(")");
/* 239 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 245 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 246 */     lb.add(new xdb.logs.ListenableChanged().setVarName("record_time"));
/* 247 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.UserLoginPrivilegeInfo {
/*     */     private Const() {}
/*     */     
/*     */     UserLoginPrivilegeInfo nThis() {
/* 254 */       return UserLoginPrivilegeInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 260 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.UserLoginPrivilegeInfo copy()
/*     */     {
/* 266 */       return UserLoginPrivilegeInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.UserLoginPrivilegeInfo toData()
/*     */     {
/* 272 */       return UserLoginPrivilegeInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.UserLoginPrivilegeInfo toBean()
/*     */     {
/* 277 */       return UserLoginPrivilegeInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.UserLoginPrivilegeInfo toDataIf()
/*     */     {
/* 283 */       return UserLoginPrivilegeInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.UserLoginPrivilegeInfo toBeanIf()
/*     */     {
/* 288 */       return UserLoginPrivilegeInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRecord_time()
/*     */     {
/* 295 */       UserLoginPrivilegeInfo.this._xdb_verify_unsafe_();
/* 296 */       return UserLoginPrivilegeInfo.this.record_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecord_time(long _v_)
/*     */     {
/* 303 */       UserLoginPrivilegeInfo.this._xdb_verify_unsafe_();
/* 304 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 310 */       UserLoginPrivilegeInfo.this._xdb_verify_unsafe_();
/* 311 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 317 */       UserLoginPrivilegeInfo.this._xdb_verify_unsafe_();
/* 318 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 324 */       return UserLoginPrivilegeInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 330 */       return UserLoginPrivilegeInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 336 */       UserLoginPrivilegeInfo.this._xdb_verify_unsafe_();
/* 337 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 343 */       return UserLoginPrivilegeInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 349 */       return UserLoginPrivilegeInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 355 */       UserLoginPrivilegeInfo.this._xdb_verify_unsafe_();
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 362 */       return UserLoginPrivilegeInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 368 */       return UserLoginPrivilegeInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 374 */       return UserLoginPrivilegeInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 380 */       return UserLoginPrivilegeInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 386 */       return UserLoginPrivilegeInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 392 */       return UserLoginPrivilegeInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 398 */       return UserLoginPrivilegeInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.UserLoginPrivilegeInfo
/*     */   {
/*     */     private long record_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 410 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 415 */       this.record_time = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.UserLoginPrivilegeInfo _o1_)
/*     */     {
/* 420 */       if ((_o1_ instanceof UserLoginPrivilegeInfo)) { assign((UserLoginPrivilegeInfo)_o1_);
/* 421 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 422 */       } else if ((_o1_ instanceof UserLoginPrivilegeInfo.Const)) assign(((UserLoginPrivilegeInfo.Const)_o1_).nThis()); else {
/* 423 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(UserLoginPrivilegeInfo _o_) {
/* 428 */       this.record_time = _o_.record_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 433 */       this.record_time = _o_.record_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 439 */       _os_.marshal(this.record_time);
/* 440 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 446 */       this.record_time = _os_.unmarshal_long();
/* 447 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 453 */       int _size_ = 0;
/* 454 */       _size_ += CodedOutputStream.computeInt64Size(1, this.record_time);
/* 455 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 463 */         _output_.writeInt64(1, this.record_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 467 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 469 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 477 */         boolean done = false;
/* 478 */         while (!done)
/*     */         {
/* 480 */           int tag = _input_.readTag();
/* 481 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 485 */             done = true;
/* 486 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 490 */             this.record_time = _input_.readInt64();
/* 491 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 495 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 497 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 506 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 510 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 512 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.UserLoginPrivilegeInfo copy()
/*     */     {
/* 518 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.UserLoginPrivilegeInfo toData()
/*     */     {
/* 524 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.UserLoginPrivilegeInfo toBean()
/*     */     {
/* 529 */       return new UserLoginPrivilegeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.UserLoginPrivilegeInfo toDataIf()
/*     */     {
/* 535 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.UserLoginPrivilegeInfo toBeanIf()
/*     */     {
/* 540 */       return new UserLoginPrivilegeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 550 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 558 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 562 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 566 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 570 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRecord_time()
/*     */     {
/* 577 */       return this.record_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecord_time(long _v_)
/*     */     {
/* 584 */       this.record_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 590 */       if (!(_o1_ instanceof Data)) return false;
/* 591 */       Data _o_ = (Data)_o1_;
/* 592 */       if (this.record_time != _o_.record_time) return false;
/* 593 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 599 */       int _h_ = 0;
/* 600 */       _h_ = (int)(_h_ + this.record_time);
/* 601 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 607 */       StringBuilder _sb_ = new StringBuilder();
/* 608 */       _sb_.append("(");
/* 609 */       _sb_.append(this.record_time);
/* 610 */       _sb_.append(")");
/* 611 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\UserLoginPrivilegeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */