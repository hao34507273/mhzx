/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
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
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class RoundRobinFightInfo extends XBean implements xbean.RoundRobinFightInfo
/*      */ {
/*      */   private long corps_a_id;
/*      */   private long corps_b_id;
/*      */   private int state;
/*      */   private long watch_roleid;
/*      */   private long recordid;
/*      */   private long corps_a_watch_roleid;
/*      */   private long corps_b_watch_roleid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.corps_a_id = 0L;
/*   31 */     this.corps_b_id = 0L;
/*   32 */     this.state = 0;
/*   33 */     this.watch_roleid = -1L;
/*   34 */     this.recordid = -1L;
/*   35 */     this.corps_a_watch_roleid = -1L;
/*   36 */     this.corps_b_watch_roleid = -1L;
/*      */   }
/*      */   
/*      */   RoundRobinFightInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.watch_roleid = -1L;
/*   43 */     this.recordid = -1L;
/*   44 */     this.corps_a_watch_roleid = -1L;
/*   45 */     this.corps_b_watch_roleid = -1L;
/*      */   }
/*      */   
/*      */   public RoundRobinFightInfo()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoundRobinFightInfo(RoundRobinFightInfo _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoundRobinFightInfo(xbean.RoundRobinFightInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof RoundRobinFightInfo)) { assign((RoundRobinFightInfo)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoundRobinFightInfo _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.corps_a_id = _o_.corps_a_id;
/*   71 */     this.corps_b_id = _o_.corps_b_id;
/*   72 */     this.state = _o_.state;
/*   73 */     this.watch_roleid = _o_.watch_roleid;
/*   74 */     this.recordid = _o_.recordid;
/*   75 */     this.corps_a_watch_roleid = _o_.corps_a_watch_roleid;
/*   76 */     this.corps_b_watch_roleid = _o_.corps_b_watch_roleid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.corps_a_id = _o_.corps_a_id;
/*   82 */     this.corps_b_id = _o_.corps_b_id;
/*   83 */     this.state = _o_.state;
/*   84 */     this.watch_roleid = _o_.watch_roleid;
/*   85 */     this.recordid = _o_.recordid;
/*   86 */     this.corps_a_watch_roleid = _o_.corps_a_watch_roleid;
/*   87 */     this.corps_b_watch_roleid = _o_.corps_b_watch_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   93 */     _xdb_verify_unsafe_();
/*   94 */     _os_.marshal(this.corps_a_id);
/*   95 */     _os_.marshal(this.corps_b_id);
/*   96 */     _os_.marshal(this.state);
/*   97 */     _os_.marshal(this.watch_roleid);
/*   98 */     _os_.marshal(this.recordid);
/*   99 */     _os_.marshal(this.corps_a_watch_roleid);
/*  100 */     _os_.marshal(this.corps_b_watch_roleid);
/*  101 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  107 */     _xdb_verify_unsafe_();
/*  108 */     this.corps_a_id = _os_.unmarshal_long();
/*  109 */     this.corps_b_id = _os_.unmarshal_long();
/*  110 */     this.state = _os_.unmarshal_int();
/*  111 */     this.watch_roleid = _os_.unmarshal_long();
/*  112 */     this.recordid = _os_.unmarshal_long();
/*  113 */     this.corps_a_watch_roleid = _os_.unmarshal_long();
/*  114 */     this.corps_b_watch_roleid = _os_.unmarshal_long();
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     int _size_ = 0;
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(1, this.corps_a_id);
/*  124 */     _size_ += CodedOutputStream.computeInt64Size(2, this.corps_b_id);
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(3, this.state);
/*  126 */     _size_ += CodedOutputStream.computeInt64Size(4, this.watch_roleid);
/*  127 */     _size_ += CodedOutputStream.computeInt64Size(5, this.recordid);
/*  128 */     _size_ += CodedOutputStream.computeInt64Size(6, this.corps_a_watch_roleid);
/*  129 */     _size_ += CodedOutputStream.computeInt64Size(7, this.corps_b_watch_roleid);
/*  130 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  139 */       _output_.writeInt64(1, this.corps_a_id);
/*  140 */       _output_.writeInt64(2, this.corps_b_id);
/*  141 */       _output_.writeInt32(3, this.state);
/*  142 */       _output_.writeInt64(4, this.watch_roleid);
/*  143 */       _output_.writeInt64(5, this.recordid);
/*  144 */       _output_.writeInt64(6, this.corps_a_watch_roleid);
/*  145 */       _output_.writeInt64(7, this.corps_b_watch_roleid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  151 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  160 */       boolean done = false;
/*  161 */       while (!done)
/*      */       {
/*  163 */         int tag = _input_.readTag();
/*  164 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  168 */           done = true;
/*  169 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  173 */           this.corps_a_id = _input_.readInt64();
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  178 */           this.corps_b_id = _input_.readInt64();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  183 */           this.state = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  188 */           this.watch_roleid = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  193 */           this.recordid = _input_.readInt64();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  198 */           this.corps_a_watch_roleid = _input_.readInt64();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  203 */           this.corps_b_watch_roleid = _input_.readInt64();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  208 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  210 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  219 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  223 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  225 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoundRobinFightInfo copy()
/*      */   {
/*  231 */     _xdb_verify_unsafe_();
/*  232 */     return new RoundRobinFightInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoundRobinFightInfo toData()
/*      */   {
/*  238 */     _xdb_verify_unsafe_();
/*  239 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoundRobinFightInfo toBean()
/*      */   {
/*  244 */     _xdb_verify_unsafe_();
/*  245 */     return new RoundRobinFightInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoundRobinFightInfo toDataIf()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoundRobinFightInfo toBeanIf()
/*      */   {
/*  257 */     _xdb_verify_unsafe_();
/*  258 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_a_id()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return this.corps_a_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_b_id()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return this.corps_b_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWatch_roleid()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this.watch_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRecordid()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this.recordid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_a_watch_roleid()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.corps_a_watch_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_b_watch_roleid()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.corps_b_watch_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_a_id(long _v_)
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     Logs.logIf(new LogKey(this, "corps_a_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  333 */         new LogLong(this, RoundRobinFightInfo.this.corps_a_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  337 */             RoundRobinFightInfo.this.corps_a_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  341 */     });
/*  342 */     this.corps_a_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_b_id(long _v_)
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     Logs.logIf(new LogKey(this, "corps_b_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  354 */         new LogLong(this, RoundRobinFightInfo.this.corps_b_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  358 */             RoundRobinFightInfo.this.corps_b_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  362 */     });
/*  363 */     this.corps_b_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  375 */         new xdb.logs.LogInt(this, RoundRobinFightInfo.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  379 */             RoundRobinFightInfo.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  383 */     });
/*  384 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWatch_roleid(long _v_)
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     Logs.logIf(new LogKey(this, "watch_roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  396 */         new LogLong(this, RoundRobinFightInfo.this.watch_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  400 */             RoundRobinFightInfo.this.watch_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  404 */     });
/*  405 */     this.watch_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecordid(long _v_)
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     Logs.logIf(new LogKey(this, "recordid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  417 */         new LogLong(this, RoundRobinFightInfo.this.recordid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  421 */             RoundRobinFightInfo.this.recordid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  425 */     });
/*  426 */     this.recordid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_a_watch_roleid(long _v_)
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     Logs.logIf(new LogKey(this, "corps_a_watch_roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  438 */         new LogLong(this, RoundRobinFightInfo.this.corps_a_watch_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  442 */             RoundRobinFightInfo.this.corps_a_watch_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  446 */     });
/*  447 */     this.corps_a_watch_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_b_watch_roleid(long _v_)
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     Logs.logIf(new LogKey(this, "corps_b_watch_roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  459 */         new LogLong(this, RoundRobinFightInfo.this.corps_b_watch_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  463 */             RoundRobinFightInfo.this.corps_b_watch_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  467 */     });
/*  468 */     this.corps_b_watch_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     RoundRobinFightInfo _o_ = null;
/*  476 */     if ((_o1_ instanceof RoundRobinFightInfo)) { _o_ = (RoundRobinFightInfo)_o1_;
/*  477 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  478 */       return false;
/*  479 */     if (this.corps_a_id != _o_.corps_a_id) return false;
/*  480 */     if (this.corps_b_id != _o_.corps_b_id) return false;
/*  481 */     if (this.state != _o_.state) return false;
/*  482 */     if (this.watch_roleid != _o_.watch_roleid) return false;
/*  483 */     if (this.recordid != _o_.recordid) return false;
/*  484 */     if (this.corps_a_watch_roleid != _o_.corps_a_watch_roleid) return false;
/*  485 */     if (this.corps_b_watch_roleid != _o_.corps_b_watch_roleid) return false;
/*  486 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     int _h_ = 0;
/*  494 */     _h_ = (int)(_h_ + this.corps_a_id);
/*  495 */     _h_ = (int)(_h_ + this.corps_b_id);
/*  496 */     _h_ += this.state;
/*  497 */     _h_ = (int)(_h_ + this.watch_roleid);
/*  498 */     _h_ = (int)(_h_ + this.recordid);
/*  499 */     _h_ = (int)(_h_ + this.corps_a_watch_roleid);
/*  500 */     _h_ = (int)(_h_ + this.corps_b_watch_roleid);
/*  501 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*  508 */     StringBuilder _sb_ = new StringBuilder();
/*  509 */     _sb_.append("(");
/*  510 */     _sb_.append(this.corps_a_id);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append(this.corps_b_id);
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.state);
/*  515 */     _sb_.append(",");
/*  516 */     _sb_.append(this.watch_roleid);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.recordid);
/*  519 */     _sb_.append(",");
/*  520 */     _sb_.append(this.corps_a_watch_roleid);
/*  521 */     _sb_.append(",");
/*  522 */     _sb_.append(this.corps_b_watch_roleid);
/*  523 */     _sb_.append(")");
/*  524 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  530 */     ListenableBean lb = new ListenableBean();
/*  531 */     lb.add(new ListenableChanged().setVarName("corps_a_id"));
/*  532 */     lb.add(new ListenableChanged().setVarName("corps_b_id"));
/*  533 */     lb.add(new ListenableChanged().setVarName("state"));
/*  534 */     lb.add(new ListenableChanged().setVarName("watch_roleid"));
/*  535 */     lb.add(new ListenableChanged().setVarName("recordid"));
/*  536 */     lb.add(new ListenableChanged().setVarName("corps_a_watch_roleid"));
/*  537 */     lb.add(new ListenableChanged().setVarName("corps_b_watch_roleid"));
/*  538 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoundRobinFightInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoundRobinFightInfo nThis() {
/*  545 */       return RoundRobinFightInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  551 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightInfo copy()
/*      */     {
/*  557 */       return RoundRobinFightInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightInfo toData()
/*      */     {
/*  563 */       return RoundRobinFightInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightInfo toBean()
/*      */     {
/*  568 */       return RoundRobinFightInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightInfo toDataIf()
/*      */     {
/*  574 */       return RoundRobinFightInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightInfo toBeanIf()
/*      */     {
/*  579 */       return RoundRobinFightInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_id()
/*      */     {
/*  586 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  587 */       return RoundRobinFightInfo.this.corps_a_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_id()
/*      */     {
/*  594 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  595 */       return RoundRobinFightInfo.this.corps_b_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  602 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  603 */       return RoundRobinFightInfo.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWatch_roleid()
/*      */     {
/*  610 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  611 */       return RoundRobinFightInfo.this.watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecordid()
/*      */     {
/*  618 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  619 */       return RoundRobinFightInfo.this.recordid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_watch_roleid()
/*      */     {
/*  626 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  627 */       return RoundRobinFightInfo.this.corps_a_watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_watch_roleid()
/*      */     {
/*  634 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  635 */       return RoundRobinFightInfo.this.corps_b_watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_id(long _v_)
/*      */     {
/*  642 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_id(long _v_)
/*      */     {
/*  650 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  658 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  659 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWatch_roleid(long _v_)
/*      */     {
/*  666 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  667 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecordid(long _v_)
/*      */     {
/*  674 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_watch_roleid(long _v_)
/*      */     {
/*  682 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_watch_roleid(long _v_)
/*      */     {
/*  690 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  697 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  698 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  704 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  705 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  711 */       return RoundRobinFightInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  717 */       return RoundRobinFightInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  723 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  724 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  730 */       return RoundRobinFightInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  736 */       return RoundRobinFightInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  742 */       RoundRobinFightInfo.this._xdb_verify_unsafe_();
/*  743 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  749 */       return RoundRobinFightInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  755 */       return RoundRobinFightInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  761 */       return RoundRobinFightInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  767 */       return RoundRobinFightInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  773 */       return RoundRobinFightInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  779 */       return RoundRobinFightInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  785 */       return RoundRobinFightInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoundRobinFightInfo
/*      */   {
/*      */     private long corps_a_id;
/*      */     
/*      */     private long corps_b_id;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private long watch_roleid;
/*      */     
/*      */     private long recordid;
/*      */     
/*      */     private long corps_a_watch_roleid;
/*      */     
/*      */     private long corps_b_watch_roleid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  809 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  814 */       this.watch_roleid = -1L;
/*  815 */       this.recordid = -1L;
/*  816 */       this.corps_a_watch_roleid = -1L;
/*  817 */       this.corps_b_watch_roleid = -1L;
/*      */     }
/*      */     
/*      */     Data(xbean.RoundRobinFightInfo _o1_)
/*      */     {
/*  822 */       if ((_o1_ instanceof RoundRobinFightInfo)) { assign((RoundRobinFightInfo)_o1_);
/*  823 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  824 */       } else if ((_o1_ instanceof RoundRobinFightInfo.Const)) assign(((RoundRobinFightInfo.Const)_o1_).nThis()); else {
/*  825 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoundRobinFightInfo _o_) {
/*  830 */       this.corps_a_id = _o_.corps_a_id;
/*  831 */       this.corps_b_id = _o_.corps_b_id;
/*  832 */       this.state = _o_.state;
/*  833 */       this.watch_roleid = _o_.watch_roleid;
/*  834 */       this.recordid = _o_.recordid;
/*  835 */       this.corps_a_watch_roleid = _o_.corps_a_watch_roleid;
/*  836 */       this.corps_b_watch_roleid = _o_.corps_b_watch_roleid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  841 */       this.corps_a_id = _o_.corps_a_id;
/*  842 */       this.corps_b_id = _o_.corps_b_id;
/*  843 */       this.state = _o_.state;
/*  844 */       this.watch_roleid = _o_.watch_roleid;
/*  845 */       this.recordid = _o_.recordid;
/*  846 */       this.corps_a_watch_roleid = _o_.corps_a_watch_roleid;
/*  847 */       this.corps_b_watch_roleid = _o_.corps_b_watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  853 */       _os_.marshal(this.corps_a_id);
/*  854 */       _os_.marshal(this.corps_b_id);
/*  855 */       _os_.marshal(this.state);
/*  856 */       _os_.marshal(this.watch_roleid);
/*  857 */       _os_.marshal(this.recordid);
/*  858 */       _os_.marshal(this.corps_a_watch_roleid);
/*  859 */       _os_.marshal(this.corps_b_watch_roleid);
/*  860 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  866 */       this.corps_a_id = _os_.unmarshal_long();
/*  867 */       this.corps_b_id = _os_.unmarshal_long();
/*  868 */       this.state = _os_.unmarshal_int();
/*  869 */       this.watch_roleid = _os_.unmarshal_long();
/*  870 */       this.recordid = _os_.unmarshal_long();
/*  871 */       this.corps_a_watch_roleid = _os_.unmarshal_long();
/*  872 */       this.corps_b_watch_roleid = _os_.unmarshal_long();
/*  873 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  879 */       int _size_ = 0;
/*  880 */       _size_ += CodedOutputStream.computeInt64Size(1, this.corps_a_id);
/*  881 */       _size_ += CodedOutputStream.computeInt64Size(2, this.corps_b_id);
/*  882 */       _size_ += CodedOutputStream.computeInt32Size(3, this.state);
/*  883 */       _size_ += CodedOutputStream.computeInt64Size(4, this.watch_roleid);
/*  884 */       _size_ += CodedOutputStream.computeInt64Size(5, this.recordid);
/*  885 */       _size_ += CodedOutputStream.computeInt64Size(6, this.corps_a_watch_roleid);
/*  886 */       _size_ += CodedOutputStream.computeInt64Size(7, this.corps_b_watch_roleid);
/*  887 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  895 */         _output_.writeInt64(1, this.corps_a_id);
/*  896 */         _output_.writeInt64(2, this.corps_b_id);
/*  897 */         _output_.writeInt32(3, this.state);
/*  898 */         _output_.writeInt64(4, this.watch_roleid);
/*  899 */         _output_.writeInt64(5, this.recordid);
/*  900 */         _output_.writeInt64(6, this.corps_a_watch_roleid);
/*  901 */         _output_.writeInt64(7, this.corps_b_watch_roleid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  905 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  907 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  915 */         boolean done = false;
/*  916 */         while (!done)
/*      */         {
/*  918 */           int tag = _input_.readTag();
/*  919 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  923 */             done = true;
/*  924 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  928 */             this.corps_a_id = _input_.readInt64();
/*  929 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  933 */             this.corps_b_id = _input_.readInt64();
/*  934 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  938 */             this.state = _input_.readInt32();
/*  939 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  943 */             this.watch_roleid = _input_.readInt64();
/*  944 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  948 */             this.recordid = _input_.readInt64();
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  953 */             this.corps_a_watch_roleid = _input_.readInt64();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  958 */             this.corps_b_watch_roleid = _input_.readInt64();
/*  959 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  963 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  965 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  974 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  978 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  980 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightInfo copy()
/*      */     {
/*  986 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightInfo toData()
/*      */     {
/*  992 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightInfo toBean()
/*      */     {
/*  997 */       return new RoundRobinFightInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightInfo toDataIf()
/*      */     {
/* 1003 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightInfo toBeanIf()
/*      */     {
/* 1008 */       return new RoundRobinFightInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1014 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1026 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1030 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1034 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_id()
/*      */     {
/* 1045 */       return this.corps_a_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_id()
/*      */     {
/* 1052 */       return this.corps_b_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1059 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWatch_roleid()
/*      */     {
/* 1066 */       return this.watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecordid()
/*      */     {
/* 1073 */       return this.recordid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_watch_roleid()
/*      */     {
/* 1080 */       return this.corps_a_watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_watch_roleid()
/*      */     {
/* 1087 */       return this.corps_b_watch_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_id(long _v_)
/*      */     {
/* 1094 */       this.corps_a_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_id(long _v_)
/*      */     {
/* 1101 */       this.corps_b_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1108 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWatch_roleid(long _v_)
/*      */     {
/* 1115 */       this.watch_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecordid(long _v_)
/*      */     {
/* 1122 */       this.recordid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_watch_roleid(long _v_)
/*      */     {
/* 1129 */       this.corps_a_watch_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_watch_roleid(long _v_)
/*      */     {
/* 1136 */       this.corps_b_watch_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1142 */       if (!(_o1_ instanceof Data)) return false;
/* 1143 */       Data _o_ = (Data)_o1_;
/* 1144 */       if (this.corps_a_id != _o_.corps_a_id) return false;
/* 1145 */       if (this.corps_b_id != _o_.corps_b_id) return false;
/* 1146 */       if (this.state != _o_.state) return false;
/* 1147 */       if (this.watch_roleid != _o_.watch_roleid) return false;
/* 1148 */       if (this.recordid != _o_.recordid) return false;
/* 1149 */       if (this.corps_a_watch_roleid != _o_.corps_a_watch_roleid) return false;
/* 1150 */       if (this.corps_b_watch_roleid != _o_.corps_b_watch_roleid) return false;
/* 1151 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1157 */       int _h_ = 0;
/* 1158 */       _h_ = (int)(_h_ + this.corps_a_id);
/* 1159 */       _h_ = (int)(_h_ + this.corps_b_id);
/* 1160 */       _h_ += this.state;
/* 1161 */       _h_ = (int)(_h_ + this.watch_roleid);
/* 1162 */       _h_ = (int)(_h_ + this.recordid);
/* 1163 */       _h_ = (int)(_h_ + this.corps_a_watch_roleid);
/* 1164 */       _h_ = (int)(_h_ + this.corps_b_watch_roleid);
/* 1165 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1171 */       StringBuilder _sb_ = new StringBuilder();
/* 1172 */       _sb_.append("(");
/* 1173 */       _sb_.append(this.corps_a_id);
/* 1174 */       _sb_.append(",");
/* 1175 */       _sb_.append(this.corps_b_id);
/* 1176 */       _sb_.append(",");
/* 1177 */       _sb_.append(this.state);
/* 1178 */       _sb_.append(",");
/* 1179 */       _sb_.append(this.watch_roleid);
/* 1180 */       _sb_.append(",");
/* 1181 */       _sb_.append(this.recordid);
/* 1182 */       _sb_.append(",");
/* 1183 */       _sb_.append(this.corps_a_watch_roleid);
/* 1184 */       _sb_.append(",");
/* 1185 */       _sb_.append(this.corps_b_watch_roleid);
/* 1186 */       _sb_.append(")");
/* 1187 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoundRobinFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */