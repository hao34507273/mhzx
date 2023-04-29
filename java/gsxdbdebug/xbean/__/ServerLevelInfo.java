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
/*     */ public final class ServerLevelInfo extends XBean implements xbean.ServerLevelInfo
/*     */ {
/*     */   private int serverlevel;
/*     */   private long starttime;
/*     */   private long time_offset;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.serverlevel = 0;
/*  23 */     this.starttime = 0L;
/*  24 */     this.time_offset = 0L;
/*     */   }
/*     */   
/*     */   ServerLevelInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ServerLevelInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ServerLevelInfo(ServerLevelInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ServerLevelInfo(xbean.ServerLevelInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof ServerLevelInfo)) { assign((ServerLevelInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ServerLevelInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.serverlevel = _o_.serverlevel;
/*  55 */     this.starttime = _o_.starttime;
/*  56 */     this.time_offset = _o_.time_offset;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.serverlevel = _o_.serverlevel;
/*  62 */     this.starttime = _o_.starttime;
/*  63 */     this.time_offset = _o_.time_offset;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.serverlevel);
/*  71 */     _os_.marshal(this.starttime);
/*  72 */     _os_.marshal(this.time_offset);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.serverlevel = _os_.unmarshal_int();
/*  81 */     this.starttime = _os_.unmarshal_long();
/*  82 */     this.time_offset = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.serverlevel);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.time_offset);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.serverlevel);
/* 104 */       _output_.writeInt64(2, this.starttime);
/* 105 */       _output_.writeInt64(3, this.time_offset);
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
/* 133 */           this.serverlevel = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.starttime = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.time_offset = _input_.readInt64();
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
/*     */   public xbean.ServerLevelInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new ServerLevelInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ServerLevelInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ServerLevelInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new ServerLevelInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ServerLevelInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ServerLevelInfo toBeanIf()
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
/*     */   public int getServerlevel()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.serverlevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStarttime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTime_offset()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.time_offset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setServerlevel(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "serverlevel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, ServerLevelInfo.this.serverlevel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             ServerLevelInfo.this.serverlevel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.serverlevel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, ServerLevelInfo.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             ServerLevelInfo.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTime_offset(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "time_offset")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, ServerLevelInfo.this.time_offset)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             ServerLevelInfo.this.time_offset = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.time_offset = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     ServerLevelInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof ServerLevelInfo)) { _o_ = (ServerLevelInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.serverlevel != _o_.serverlevel) return false;
/* 304 */     if (this.starttime != _o_.starttime) return false;
/* 305 */     if (this.time_offset != _o_.time_offset) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.serverlevel;
/* 315 */     _h_ = (int)(_h_ + this.starttime);
/* 316 */     _h_ = (int)(_h_ + this.time_offset);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.serverlevel);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.starttime);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.time_offset);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("serverlevel"));
/* 340 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 341 */     lb.add(new ListenableChanged().setVarName("time_offset"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ServerLevelInfo {
/*     */     private Const() {}
/*     */     
/*     */     ServerLevelInfo nThis() {
/* 349 */       return ServerLevelInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ServerLevelInfo copy()
/*     */     {
/* 361 */       return ServerLevelInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ServerLevelInfo toData()
/*     */     {
/* 367 */       return ServerLevelInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ServerLevelInfo toBean()
/*     */     {
/* 372 */       return ServerLevelInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ServerLevelInfo toDataIf()
/*     */     {
/* 378 */       return ServerLevelInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ServerLevelInfo toBeanIf()
/*     */     {
/* 383 */       return ServerLevelInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getServerlevel()
/*     */     {
/* 390 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 391 */       return ServerLevelInfo.this.serverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 398 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 399 */       return ServerLevelInfo.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTime_offset()
/*     */     {
/* 406 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 407 */       return ServerLevelInfo.this.time_offset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setServerlevel(int _v_)
/*     */     {
/* 414 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 422 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime_offset(long _v_)
/*     */     {
/* 430 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return ServerLevelInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return ServerLevelInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return ServerLevelInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return ServerLevelInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       ServerLevelInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return ServerLevelInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return ServerLevelInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return ServerLevelInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return ServerLevelInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return ServerLevelInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return ServerLevelInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return ServerLevelInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ServerLevelInfo
/*     */   {
/*     */     private int serverlevel;
/*     */     
/*     */     private long starttime;
/*     */     
/*     */     private long time_offset;
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
/*     */     Data(xbean.ServerLevelInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof ServerLevelInfo)) { assign((ServerLevelInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof ServerLevelInfo.Const)) assign(((ServerLevelInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ServerLevelInfo _o_) {
/* 558 */       this.serverlevel = _o_.serverlevel;
/* 559 */       this.starttime = _o_.starttime;
/* 560 */       this.time_offset = _o_.time_offset;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.serverlevel = _o_.serverlevel;
/* 566 */       this.starttime = _o_.starttime;
/* 567 */       this.time_offset = _o_.time_offset;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.serverlevel);
/* 574 */       _os_.marshal(this.starttime);
/* 575 */       _os_.marshal(this.time_offset);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.serverlevel = _os_.unmarshal_int();
/* 583 */       this.starttime = _os_.unmarshal_long();
/* 584 */       this.time_offset = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.serverlevel);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.time_offset);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.serverlevel);
/* 604 */         _output_.writeInt64(2, this.starttime);
/* 605 */         _output_.writeInt64(3, this.time_offset);
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
/* 632 */             this.serverlevel = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.starttime = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.time_offset = _input_.readInt64();
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
/*     */     public xbean.ServerLevelInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ServerLevelInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ServerLevelInfo toBean()
/*     */     {
/* 681 */       return new ServerLevelInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ServerLevelInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ServerLevelInfo toBeanIf()
/*     */     {
/* 692 */       return new ServerLevelInfo(this, null, null);
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
/*     */     public int getServerlevel()
/*     */     {
/* 729 */       return this.serverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 736 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTime_offset()
/*     */     {
/* 743 */       return this.time_offset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setServerlevel(int _v_)
/*     */     {
/* 750 */       this.serverlevel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 757 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime_offset(long _v_)
/*     */     {
/* 764 */       this.time_offset = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.serverlevel != _o_.serverlevel) return false;
/* 773 */       if (this.starttime != _o_.starttime) return false;
/* 774 */       if (this.time_offset != _o_.time_offset) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.serverlevel;
/* 783 */       _h_ = (int)(_h_ + this.starttime);
/* 784 */       _h_ = (int)(_h_ + this.time_offset);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.serverlevel);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.starttime);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.time_offset);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ServerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */