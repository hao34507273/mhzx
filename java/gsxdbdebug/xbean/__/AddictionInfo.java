/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class AddictionInfo extends XBean implements xbean.AddictionInfo
/*      */ {
/*      */   private int identity;
/*      */   private long update_time;
/*      */   private int online_time;
/*      */   private int total_online_time;
/*      */   private boolean reminded;
/*      */   private int kickout_type;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.identity = 2;
/*   29 */     this.update_time = 0L;
/*   30 */     this.online_time = 0;
/*   31 */     this.total_online_time = 0;
/*   32 */     this.reminded = false;
/*   33 */     this.kickout_type = 0;
/*      */   }
/*      */   
/*      */   AddictionInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.identity = 2;
/*      */   }
/*      */   
/*      */   public AddictionInfo()
/*      */   {
/*   44 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AddictionInfo(AddictionInfo _o_)
/*      */   {
/*   49 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AddictionInfo(xbean.AddictionInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   54 */     super(_xp_, _vn_);
/*   55 */     if ((_o1_ instanceof AddictionInfo)) { assign((AddictionInfo)_o1_);
/*   56 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   57 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   58 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AddictionInfo _o_) {
/*   63 */     _o_._xdb_verify_unsafe_();
/*   64 */     this.identity = _o_.identity;
/*   65 */     this.update_time = _o_.update_time;
/*   66 */     this.online_time = _o_.online_time;
/*   67 */     this.total_online_time = _o_.total_online_time;
/*   68 */     this.reminded = _o_.reminded;
/*   69 */     this.kickout_type = _o_.kickout_type;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   74 */     this.identity = _o_.identity;
/*   75 */     this.update_time = _o_.update_time;
/*   76 */     this.online_time = _o_.online_time;
/*   77 */     this.total_online_time = _o_.total_online_time;
/*   78 */     this.reminded = _o_.reminded;
/*   79 */     this.kickout_type = _o_.kickout_type;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.marshal(this.identity);
/*   87 */     _os_.marshal(this.update_time);
/*   88 */     _os_.marshal(this.online_time);
/*   89 */     _os_.marshal(this.total_online_time);
/*   90 */     _os_.marshal(this.reminded);
/*   91 */     _os_.marshal(this.kickout_type);
/*   92 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     this.identity = _os_.unmarshal_int();
/*  100 */     this.update_time = _os_.unmarshal_long();
/*  101 */     this.online_time = _os_.unmarshal_int();
/*  102 */     this.total_online_time = _os_.unmarshal_int();
/*  103 */     this.reminded = _os_.unmarshal_boolean();
/*  104 */     this.kickout_type = _os_.unmarshal_int();
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     int _size_ = 0;
/*  113 */     _size_ += CodedOutputStream.computeInt32Size(1, this.identity);
/*  114 */     _size_ += CodedOutputStream.computeInt64Size(2, this.update_time);
/*  115 */     _size_ += CodedOutputStream.computeInt32Size(3, this.online_time);
/*  116 */     _size_ += CodedOutputStream.computeInt32Size(4, this.total_online_time);
/*  117 */     _size_ += CodedOutputStream.computeBoolSize(5, this.reminded);
/*  118 */     _size_ += CodedOutputStream.computeInt32Size(6, this.kickout_type);
/*  119 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  128 */       _output_.writeInt32(1, this.identity);
/*  129 */       _output_.writeInt64(2, this.update_time);
/*  130 */       _output_.writeInt32(3, this.online_time);
/*  131 */       _output_.writeInt32(4, this.total_online_time);
/*  132 */       _output_.writeBool(5, this.reminded);
/*  133 */       _output_.writeInt32(6, this.kickout_type);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  137 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  139 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  148 */       boolean done = false;
/*  149 */       while (!done)
/*      */       {
/*  151 */         int tag = _input_.readTag();
/*  152 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  156 */           done = true;
/*  157 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  161 */           this.identity = _input_.readInt32();
/*  162 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  166 */           this.update_time = _input_.readInt64();
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  171 */           this.online_time = _input_.readInt32();
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  176 */           this.total_online_time = _input_.readInt32();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  181 */           this.reminded = _input_.readBool();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  186 */           this.kickout_type = _input_.readInt32();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  191 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  193 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  202 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  206 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  208 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AddictionInfo copy()
/*      */   {
/*  214 */     _xdb_verify_unsafe_();
/*  215 */     return new AddictionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AddictionInfo toData()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AddictionInfo toBean()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     return new AddictionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AddictionInfo toDataIf()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AddictionInfo toBeanIf()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIdentity()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return this.identity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getUpdate_time()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return this.update_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOnline_time()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return this.online_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_online_time()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this.total_online_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getReminded()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this.reminded;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getKickout_type()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this.kickout_type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIdentity(int _v_)
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     Logs.logIf(new LogKey(this, "identity")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  308 */         new LogInt(this, AddictionInfo.this.identity)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  312 */             AddictionInfo.this.identity = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  316 */     });
/*  317 */     this.identity = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdate_time(long _v_)
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     Logs.logIf(new LogKey(this, "update_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  329 */         new xdb.logs.LogLong(this, AddictionInfo.this.update_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  333 */             AddictionInfo.this.update_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  337 */     });
/*  338 */     this.update_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOnline_time(int _v_)
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     Logs.logIf(new LogKey(this, "online_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  350 */         new LogInt(this, AddictionInfo.this.online_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  354 */             AddictionInfo.this.online_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  358 */     });
/*  359 */     this.online_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_online_time(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     Logs.logIf(new LogKey(this, "total_online_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  371 */         new LogInt(this, AddictionInfo.this.total_online_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             AddictionInfo.this.total_online_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.total_online_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReminded(boolean _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     Logs.logIf(new LogKey(this, "reminded")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  392 */         new xdb.logs.LogObject(this, Boolean.valueOf(AddictionInfo.this.reminded))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             AddictionInfo.this.reminded = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.reminded = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKickout_type(int _v_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     Logs.logIf(new LogKey(this, "kickout_type")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  413 */         new LogInt(this, AddictionInfo.this.kickout_type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  417 */             AddictionInfo.this.kickout_type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  421 */     });
/*  422 */     this.kickout_type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     AddictionInfo _o_ = null;
/*  430 */     if ((_o1_ instanceof AddictionInfo)) { _o_ = (AddictionInfo)_o1_;
/*  431 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  432 */       return false;
/*  433 */     if (this.identity != _o_.identity) return false;
/*  434 */     if (this.update_time != _o_.update_time) return false;
/*  435 */     if (this.online_time != _o_.online_time) return false;
/*  436 */     if (this.total_online_time != _o_.total_online_time) return false;
/*  437 */     if (this.reminded != _o_.reminded) return false;
/*  438 */     if (this.kickout_type != _o_.kickout_type) return false;
/*  439 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     int _h_ = 0;
/*  447 */     _h_ += this.identity;
/*  448 */     _h_ = (int)(_h_ + this.update_time);
/*  449 */     _h_ += this.online_time;
/*  450 */     _h_ += this.total_online_time;
/*  451 */     _h_ += (this.reminded ? 1231 : 1237);
/*  452 */     _h_ += this.kickout_type;
/*  453 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     StringBuilder _sb_ = new StringBuilder();
/*  461 */     _sb_.append("(");
/*  462 */     _sb_.append(this.identity);
/*  463 */     _sb_.append(",");
/*  464 */     _sb_.append(this.update_time);
/*  465 */     _sb_.append(",");
/*  466 */     _sb_.append(this.online_time);
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.total_online_time);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.reminded);
/*  471 */     _sb_.append(",");
/*  472 */     _sb_.append(this.kickout_type);
/*  473 */     _sb_.append(")");
/*  474 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  480 */     ListenableBean lb = new ListenableBean();
/*  481 */     lb.add(new ListenableChanged().setVarName("identity"));
/*  482 */     lb.add(new ListenableChanged().setVarName("update_time"));
/*  483 */     lb.add(new ListenableChanged().setVarName("online_time"));
/*  484 */     lb.add(new ListenableChanged().setVarName("total_online_time"));
/*  485 */     lb.add(new ListenableChanged().setVarName("reminded"));
/*  486 */     lb.add(new ListenableChanged().setVarName("kickout_type"));
/*  487 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AddictionInfo {
/*      */     private Const() {}
/*      */     
/*      */     AddictionInfo nThis() {
/*  494 */       return AddictionInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  500 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AddictionInfo copy()
/*      */     {
/*  506 */       return AddictionInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AddictionInfo toData()
/*      */     {
/*  512 */       return AddictionInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AddictionInfo toBean()
/*      */     {
/*  517 */       return AddictionInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AddictionInfo toDataIf()
/*      */     {
/*  523 */       return AddictionInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AddictionInfo toBeanIf()
/*      */     {
/*  528 */       return AddictionInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIdentity()
/*      */     {
/*  535 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  536 */       return AddictionInfo.this.identity;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdate_time()
/*      */     {
/*  543 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  544 */       return AddictionInfo.this.update_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOnline_time()
/*      */     {
/*  551 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  552 */       return AddictionInfo.this.online_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_online_time()
/*      */     {
/*  559 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  560 */       return AddictionInfo.this.total_online_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getReminded()
/*      */     {
/*  567 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  568 */       return AddictionInfo.this.reminded;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKickout_type()
/*      */     {
/*  575 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  576 */       return AddictionInfo.this.kickout_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIdentity(int _v_)
/*      */     {
/*  583 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  584 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_time(long _v_)
/*      */     {
/*  591 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  592 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnline_time(int _v_)
/*      */     {
/*  599 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  600 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_online_time(int _v_)
/*      */     {
/*  607 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReminded(boolean _v_)
/*      */     {
/*  615 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  616 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKickout_type(int _v_)
/*      */     {
/*  623 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  630 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  631 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  637 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  638 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  644 */       return AddictionInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  650 */       return AddictionInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  656 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  657 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  663 */       return AddictionInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  669 */       return AddictionInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  675 */       AddictionInfo.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  682 */       return AddictionInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  688 */       return AddictionInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  694 */       return AddictionInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  700 */       return AddictionInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  706 */       return AddictionInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  712 */       return AddictionInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  718 */       return AddictionInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AddictionInfo
/*      */   {
/*      */     private int identity;
/*      */     
/*      */     private long update_time;
/*      */     
/*      */     private int online_time;
/*      */     
/*      */     private int total_online_time;
/*      */     
/*      */     private boolean reminded;
/*      */     
/*      */     private int kickout_type;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  745 */       this.identity = 2;
/*      */     }
/*      */     
/*      */     Data(xbean.AddictionInfo _o1_)
/*      */     {
/*  750 */       if ((_o1_ instanceof AddictionInfo)) { assign((AddictionInfo)_o1_);
/*  751 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  752 */       } else if ((_o1_ instanceof AddictionInfo.Const)) assign(((AddictionInfo.Const)_o1_).nThis()); else {
/*  753 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AddictionInfo _o_) {
/*  758 */       this.identity = _o_.identity;
/*  759 */       this.update_time = _o_.update_time;
/*  760 */       this.online_time = _o_.online_time;
/*  761 */       this.total_online_time = _o_.total_online_time;
/*  762 */       this.reminded = _o_.reminded;
/*  763 */       this.kickout_type = _o_.kickout_type;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  768 */       this.identity = _o_.identity;
/*  769 */       this.update_time = _o_.update_time;
/*  770 */       this.online_time = _o_.online_time;
/*  771 */       this.total_online_time = _o_.total_online_time;
/*  772 */       this.reminded = _o_.reminded;
/*  773 */       this.kickout_type = _o_.kickout_type;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  779 */       _os_.marshal(this.identity);
/*  780 */       _os_.marshal(this.update_time);
/*  781 */       _os_.marshal(this.online_time);
/*  782 */       _os_.marshal(this.total_online_time);
/*  783 */       _os_.marshal(this.reminded);
/*  784 */       _os_.marshal(this.kickout_type);
/*  785 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  791 */       this.identity = _os_.unmarshal_int();
/*  792 */       this.update_time = _os_.unmarshal_long();
/*  793 */       this.online_time = _os_.unmarshal_int();
/*  794 */       this.total_online_time = _os_.unmarshal_int();
/*  795 */       this.reminded = _os_.unmarshal_boolean();
/*  796 */       this.kickout_type = _os_.unmarshal_int();
/*  797 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  803 */       int _size_ = 0;
/*  804 */       _size_ += CodedOutputStream.computeInt32Size(1, this.identity);
/*  805 */       _size_ += CodedOutputStream.computeInt64Size(2, this.update_time);
/*  806 */       _size_ += CodedOutputStream.computeInt32Size(3, this.online_time);
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(4, this.total_online_time);
/*  808 */       _size_ += CodedOutputStream.computeBoolSize(5, this.reminded);
/*  809 */       _size_ += CodedOutputStream.computeInt32Size(6, this.kickout_type);
/*  810 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  818 */         _output_.writeInt32(1, this.identity);
/*  819 */         _output_.writeInt64(2, this.update_time);
/*  820 */         _output_.writeInt32(3, this.online_time);
/*  821 */         _output_.writeInt32(4, this.total_online_time);
/*  822 */         _output_.writeBool(5, this.reminded);
/*  823 */         _output_.writeInt32(6, this.kickout_type);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  827 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  829 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  837 */         boolean done = false;
/*  838 */         while (!done)
/*      */         {
/*  840 */           int tag = _input_.readTag();
/*  841 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  845 */             done = true;
/*  846 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  850 */             this.identity = _input_.readInt32();
/*  851 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  855 */             this.update_time = _input_.readInt64();
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  860 */             this.online_time = _input_.readInt32();
/*  861 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  865 */             this.total_online_time = _input_.readInt32();
/*  866 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  870 */             this.reminded = _input_.readBool();
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  875 */             this.kickout_type = _input_.readInt32();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  880 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  882 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  891 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AddictionInfo copy()
/*      */     {
/*  903 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AddictionInfo toData()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AddictionInfo toBean()
/*      */     {
/*  914 */       return new AddictionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AddictionInfo toDataIf()
/*      */     {
/*  920 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AddictionInfo toBeanIf()
/*      */     {
/*  925 */       return new AddictionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  931 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  951 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  955 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIdentity()
/*      */     {
/*  962 */       return this.identity;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdate_time()
/*      */     {
/*  969 */       return this.update_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOnline_time()
/*      */     {
/*  976 */       return this.online_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_online_time()
/*      */     {
/*  983 */       return this.total_online_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getReminded()
/*      */     {
/*  990 */       return this.reminded;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKickout_type()
/*      */     {
/*  997 */       return this.kickout_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIdentity(int _v_)
/*      */     {
/* 1004 */       this.identity = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_time(long _v_)
/*      */     {
/* 1011 */       this.update_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnline_time(int _v_)
/*      */     {
/* 1018 */       this.online_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_online_time(int _v_)
/*      */     {
/* 1025 */       this.total_online_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReminded(boolean _v_)
/*      */     {
/* 1032 */       this.reminded = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKickout_type(int _v_)
/*      */     {
/* 1039 */       this.kickout_type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1045 */       if (!(_o1_ instanceof Data)) return false;
/* 1046 */       Data _o_ = (Data)_o1_;
/* 1047 */       if (this.identity != _o_.identity) return false;
/* 1048 */       if (this.update_time != _o_.update_time) return false;
/* 1049 */       if (this.online_time != _o_.online_time) return false;
/* 1050 */       if (this.total_online_time != _o_.total_online_time) return false;
/* 1051 */       if (this.reminded != _o_.reminded) return false;
/* 1052 */       if (this.kickout_type != _o_.kickout_type) return false;
/* 1053 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1059 */       int _h_ = 0;
/* 1060 */       _h_ += this.identity;
/* 1061 */       _h_ = (int)(_h_ + this.update_time);
/* 1062 */       _h_ += this.online_time;
/* 1063 */       _h_ += this.total_online_time;
/* 1064 */       _h_ += (this.reminded ? 1231 : 1237);
/* 1065 */       _h_ += this.kickout_type;
/* 1066 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1072 */       StringBuilder _sb_ = new StringBuilder();
/* 1073 */       _sb_.append("(");
/* 1074 */       _sb_.append(this.identity);
/* 1075 */       _sb_.append(",");
/* 1076 */       _sb_.append(this.update_time);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.online_time);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.total_online_time);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.reminded);
/* 1083 */       _sb_.append(",");
/* 1084 */       _sb_.append(this.kickout_type);
/* 1085 */       _sb_.append(")");
/* 1086 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AddictionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */