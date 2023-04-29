/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class IDIPCmdInfo extends XBean implements xbean.IDIPCmdInfo
/*     */ {
/*     */   private long timestamp;
/*     */   private byte[] reqdata;
/*     */   private byte[] rspdata;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.timestamp = 0L;
/*  23 */     this.reqdata = new byte[0];
/*  24 */     this.rspdata = new byte[0];
/*     */   }
/*     */   
/*     */   IDIPCmdInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.reqdata = new byte[0];
/*  31 */     this.rspdata = new byte[0];
/*     */   }
/*     */   
/*     */   public IDIPCmdInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public IDIPCmdInfo(IDIPCmdInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   IDIPCmdInfo(xbean.IDIPCmdInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof IDIPCmdInfo)) { assign((IDIPCmdInfo)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(IDIPCmdInfo _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.timestamp = _o_.timestamp;
/*  57 */     this.reqdata = Arrays.copyOf(_o_.reqdata, _o_.reqdata.length);
/*  58 */     this.rspdata = Arrays.copyOf(_o_.rspdata, _o_.rspdata.length);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.timestamp = _o_.timestamp;
/*  64 */     this.reqdata = Arrays.copyOf(_o_.reqdata, _o_.reqdata.length);
/*  65 */     this.rspdata = Arrays.copyOf(_o_.rspdata, _o_.rspdata.length);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _xdb_verify_unsafe_();
/*  72 */     _os_.marshal(this.timestamp);
/*  73 */     _os_.marshal(this.reqdata);
/*  74 */     _os_.marshal(this.rspdata);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.timestamp = _os_.unmarshal_long();
/*  83 */     this.reqdata = _os_.unmarshal_bytes();
/*  84 */     this.rspdata = _os_.unmarshal_bytes();
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     int _size_ = 0;
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(1, this.timestamp);
/*  94 */     _size_ += CodedOutputStream.computeByteArraySize(2, this.reqdata);
/*  95 */     _size_ += CodedOutputStream.computeByteArraySize(3, this.rspdata);
/*  96 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 102 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 105 */       _output_.writeInt64(1, this.timestamp);
/* 106 */       _output_.writeByteArray(2, this.reqdata);
/* 107 */       _output_.writeByteArray(3, this.rspdata);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 111 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 113 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       boolean done = false;
/* 123 */       while (!done)
/*     */       {
/* 125 */         int tag = _input_.readTag();
/* 126 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 130 */           done = true;
/* 131 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 135 */           this.timestamp = _input_.readInt64();
/* 136 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 140 */           this.reqdata = _input_.readByteArray();
/* 141 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 145 */           this.rspdata = _input_.readByteArray();
/* 146 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 150 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 152 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 161 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 165 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 167 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IDIPCmdInfo copy()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return new IDIPCmdInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IDIPCmdInfo toData()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IDIPCmdInfo toBean()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new IDIPCmdInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IDIPCmdInfo toDataIf()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IDIPCmdInfo toBeanIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTimestamp()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return this.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public <T extends Marshal> T getReqdata(T _v_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 225 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.reqdata)));
/* 226 */       return _v_;
/*     */     }
/*     */     catch (MarshalException _e_)
/*     */     {
/* 230 */       throw new xio.MarshalError();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isReqdataEmpty()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.reqdata.length == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public byte[] getReqdataCopy()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return Arrays.copyOf(this.reqdata, this.reqdata.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public <T extends Marshal> T getRspdata(T _v_)
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 257 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.rspdata)));
/* 258 */       return _v_;
/*     */     }
/*     */     catch (MarshalException _e_)
/*     */     {
/* 262 */       throw new xio.MarshalError();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isRspdataEmpty()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     return this.rspdata.length == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public byte[] getRspdataCopy()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     return Arrays.copyOf(this.rspdata, this.rspdata.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimestamp(long _v_)
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     xdb.Logs.logIf(new LogKey(this, "timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 291 */         new xdb.logs.LogLong(this, IDIPCmdInfo.this.timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 295 */             IDIPCmdInfo.this.timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 299 */     });
/* 300 */     this.timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReqdata(Marshal _v_)
/*     */   {
/* 307 */     _xdb_verify_unsafe_();
/* 308 */     xdb.Logs.logIf(new LogKey(this, "reqdata")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 312 */         new xdb.logs.LogObject(this, IDIPCmdInfo.this.reqdata)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 316 */             IDIPCmdInfo.this.reqdata = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 320 */     });
/* 321 */     this.reqdata = _v_.marshal(new OctetsStream()).getBytes();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReqdataCopy(byte[] _v_)
/*     */   {
/* 328 */     _xdb_verify_unsafe_();
/* 329 */     xdb.Logs.logIf(new LogKey(this, "reqdata")
/*     */     {
/*     */       protected xdb.Log create() {
/* 332 */         new xdb.logs.LogObject(this, IDIPCmdInfo.this.reqdata)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 336 */             IDIPCmdInfo.this.reqdata = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 340 */     });
/* 341 */     this.reqdata = Arrays.copyOf(_v_, _v_.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRspdata(Marshal _v_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     xdb.Logs.logIf(new LogKey(this, "rspdata")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 353 */         new xdb.logs.LogObject(this, IDIPCmdInfo.this.rspdata)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 357 */             IDIPCmdInfo.this.rspdata = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 361 */     });
/* 362 */     this.rspdata = _v_.marshal(new OctetsStream()).getBytes();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRspdataCopy(byte[] _v_)
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     xdb.Logs.logIf(new LogKey(this, "rspdata")
/*     */     {
/*     */       protected xdb.Log create() {
/* 373 */         new xdb.logs.LogObject(this, IDIPCmdInfo.this.rspdata)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 377 */             IDIPCmdInfo.this.rspdata = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 381 */     });
/* 382 */     this.rspdata = Arrays.copyOf(_v_, _v_.length);
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 388 */     _xdb_verify_unsafe_();
/* 389 */     IDIPCmdInfo _o_ = null;
/* 390 */     if ((_o1_ instanceof IDIPCmdInfo)) { _o_ = (IDIPCmdInfo)_o1_;
/* 391 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 392 */       return false;
/* 393 */     if (this.timestamp != _o_.timestamp) return false;
/* 394 */     if (!Arrays.equals(this.reqdata, _o_.reqdata)) return false;
/* 395 */     if (!Arrays.equals(this.rspdata, _o_.rspdata)) return false;
/* 396 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 402 */     _xdb_verify_unsafe_();
/* 403 */     int _h_ = 0;
/* 404 */     _h_ = (int)(_h_ + this.timestamp);
/* 405 */     _h_ += Arrays.hashCode(this.reqdata);
/* 406 */     _h_ += Arrays.hashCode(this.rspdata);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.timestamp);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append('B').append(this.reqdata.length);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append('B').append(this.rspdata.length);
/* 421 */     _sb_.append(")");
/* 422 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 428 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 429 */     lb.add(new xdb.logs.ListenableChanged().setVarName("timestamp"));
/* 430 */     lb.add(new xdb.logs.ListenableChanged().setVarName("reqdata"));
/* 431 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rspdata"));
/* 432 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.IDIPCmdInfo {
/*     */     private Const() {}
/*     */     
/*     */     IDIPCmdInfo nThis() {
/* 439 */       return IDIPCmdInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 445 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IDIPCmdInfo copy()
/*     */     {
/* 451 */       return IDIPCmdInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IDIPCmdInfo toData()
/*     */     {
/* 457 */       return IDIPCmdInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.IDIPCmdInfo toBean()
/*     */     {
/* 462 */       return IDIPCmdInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IDIPCmdInfo toDataIf()
/*     */     {
/* 468 */       return IDIPCmdInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.IDIPCmdInfo toBeanIf()
/*     */     {
/* 473 */       return IDIPCmdInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 480 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 481 */       return IDIPCmdInfo.this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getReqdata(T _v_)
/*     */     {
/* 488 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 489 */       return IDIPCmdInfo.this.getReqdata(_v_);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isReqdataEmpty()
/*     */     {
/* 496 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 497 */       return IDIPCmdInfo.this.isReqdataEmpty();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getReqdataCopy()
/*     */     {
/* 504 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 505 */       return IDIPCmdInfo.this.getReqdataCopy();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getRspdata(T _v_)
/*     */     {
/* 512 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 513 */       return IDIPCmdInfo.this.getRspdata(_v_);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isRspdataEmpty()
/*     */     {
/* 520 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 521 */       return IDIPCmdInfo.this.isRspdataEmpty();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getRspdataCopy()
/*     */     {
/* 528 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 529 */       return IDIPCmdInfo.this.getRspdataCopy();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 536 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReqdata(Marshal _v_)
/*     */     {
/* 544 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 545 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReqdataCopy(byte[] _v_)
/*     */     {
/* 552 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 553 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRspdata(Marshal _v_)
/*     */     {
/* 560 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 561 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRspdataCopy(byte[] _v_)
/*     */     {
/* 568 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 569 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 575 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 576 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 582 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 583 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 589 */       return IDIPCmdInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 595 */       return IDIPCmdInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 601 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 602 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 608 */       return IDIPCmdInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 614 */       return IDIPCmdInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 620 */       IDIPCmdInfo.this._xdb_verify_unsafe_();
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 627 */       return IDIPCmdInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 633 */       return IDIPCmdInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 639 */       return IDIPCmdInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 645 */       return IDIPCmdInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 651 */       return IDIPCmdInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 657 */       return IDIPCmdInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 663 */       return IDIPCmdInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.IDIPCmdInfo
/*     */   {
/*     */     private long timestamp;
/*     */     
/*     */     private byte[] reqdata;
/*     */     
/*     */     private byte[] rspdata;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 679 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 684 */       this.reqdata = new byte[0];
/* 685 */       this.rspdata = new byte[0];
/*     */     }
/*     */     
/*     */     Data(xbean.IDIPCmdInfo _o1_)
/*     */     {
/* 690 */       if ((_o1_ instanceof IDIPCmdInfo)) { assign((IDIPCmdInfo)_o1_);
/* 691 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 692 */       } else if ((_o1_ instanceof IDIPCmdInfo.Const)) assign(((IDIPCmdInfo.Const)_o1_).nThis()); else {
/* 693 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(IDIPCmdInfo _o_) {
/* 698 */       this.timestamp = _o_.timestamp;
/* 699 */       this.reqdata = Arrays.copyOf(_o_.reqdata, _o_.reqdata.length);
/* 700 */       this.rspdata = Arrays.copyOf(_o_.rspdata, _o_.rspdata.length);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 705 */       this.timestamp = _o_.timestamp;
/* 706 */       this.reqdata = Arrays.copyOf(_o_.reqdata, _o_.reqdata.length);
/* 707 */       this.rspdata = Arrays.copyOf(_o_.rspdata, _o_.rspdata.length);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 713 */       _os_.marshal(this.timestamp);
/* 714 */       _os_.marshal(this.reqdata);
/* 715 */       _os_.marshal(this.rspdata);
/* 716 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 722 */       this.timestamp = _os_.unmarshal_long();
/* 723 */       this.reqdata = _os_.unmarshal_bytes();
/* 724 */       this.rspdata = _os_.unmarshal_bytes();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt64Size(1, this.timestamp);
/* 733 */       _size_ += CodedOutputStream.computeByteArraySize(2, this.reqdata);
/* 734 */       _size_ += CodedOutputStream.computeByteArraySize(3, this.rspdata);
/* 735 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 743 */         _output_.writeInt64(1, this.timestamp);
/* 744 */         _output_.writeByteArray(2, this.reqdata);
/* 745 */         _output_.writeByteArray(3, this.rspdata);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             this.timestamp = _input_.readInt64();
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 777 */             this.reqdata = _input_.readByteArray();
/* 778 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 782 */             this.rspdata = _input_.readByteArray();
/* 783 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 787 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 789 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 798 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 802 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 804 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IDIPCmdInfo copy()
/*     */     {
/* 810 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IDIPCmdInfo toData()
/*     */     {
/* 816 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.IDIPCmdInfo toBean()
/*     */     {
/* 821 */       return new IDIPCmdInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IDIPCmdInfo toDataIf()
/*     */     {
/* 827 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.IDIPCmdInfo toBeanIf()
/*     */     {
/* 832 */       return new IDIPCmdInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 838 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 842 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 846 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 850 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 858 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 862 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 869 */       return this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getReqdata(T _v_)
/*     */     {
/*     */       try
/*     */       {
/* 878 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.reqdata)));
/* 879 */         return _v_;
/*     */       }
/*     */       catch (MarshalException _e_)
/*     */       {
/* 883 */         throw new xio.MarshalError();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isReqdataEmpty()
/*     */     {
/* 891 */       return this.reqdata.length == 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getReqdataCopy()
/*     */     {
/* 898 */       return Arrays.copyOf(this.reqdata, this.reqdata.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getRspdata(T _v_)
/*     */     {
/*     */       try
/*     */       {
/* 907 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.rspdata)));
/* 908 */         return _v_;
/*     */       }
/*     */       catch (MarshalException _e_)
/*     */       {
/* 912 */         throw new xio.MarshalError();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isRspdataEmpty()
/*     */     {
/* 920 */       return this.rspdata.length == 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getRspdataCopy()
/*     */     {
/* 927 */       return Arrays.copyOf(this.rspdata, this.rspdata.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 934 */       this.timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReqdata(Marshal _v_)
/*     */     {
/* 941 */       this.reqdata = _v_.marshal(new OctetsStream()).getBytes();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReqdataCopy(byte[] _v_)
/*     */     {
/* 948 */       this.reqdata = Arrays.copyOf(_v_, _v_.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRspdata(Marshal _v_)
/*     */     {
/* 955 */       this.rspdata = _v_.marshal(new OctetsStream()).getBytes();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRspdataCopy(byte[] _v_)
/*     */     {
/* 962 */       this.rspdata = Arrays.copyOf(_v_, _v_.length);
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 968 */       if (!(_o1_ instanceof Data)) return false;
/* 969 */       Data _o_ = (Data)_o1_;
/* 970 */       if (this.timestamp != _o_.timestamp) return false;
/* 971 */       if (!Arrays.equals(this.reqdata, _o_.reqdata)) return false;
/* 972 */       if (!Arrays.equals(this.rspdata, _o_.rspdata)) return false;
/* 973 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 979 */       int _h_ = 0;
/* 980 */       _h_ = (int)(_h_ + this.timestamp);
/* 981 */       _h_ += Arrays.hashCode(this.reqdata);
/* 982 */       _h_ += Arrays.hashCode(this.rspdata);
/* 983 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 989 */       StringBuilder _sb_ = new StringBuilder();
/* 990 */       _sb_.append("(");
/* 991 */       _sb_.append(this.timestamp);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append('B').append(this.reqdata.length);
/* 994 */       _sb_.append(",");
/* 995 */       _sb_.append('B').append(this.rspdata.length);
/* 996 */       _sb_.append(")");
/* 997 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IDIPCmdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */