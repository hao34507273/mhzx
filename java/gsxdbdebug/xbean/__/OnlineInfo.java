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
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class OnlineInfo extends XBean implements xbean.OnlineInfo
/*      */ {
/*      */   private long lastcalcuatetime;
/*      */   private int single_online;
/*      */   private int is_adult;
/*      */   private int accumu_time;
/*      */   private int age;
/*      */   private int report_count;
/*      */   private int period_time;
/*      */   private int kickout_type;
/*      */   private int rest_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.lastcalcuatetime = 0L;
/*   35 */     this.single_online = 0;
/*   36 */     this.is_adult = 0;
/*   37 */     this.accumu_time = 0;
/*   38 */     this.age = 0;
/*   39 */     this.report_count = 0;
/*   40 */     this.period_time = 0;
/*   41 */     this.kickout_type = 0;
/*   42 */     this.rest_time = 0;
/*      */   }
/*      */   
/*      */   OnlineInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public OnlineInfo()
/*      */   {
/*   52 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public OnlineInfo(OnlineInfo _o_)
/*      */   {
/*   57 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   OnlineInfo(xbean.OnlineInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     if ((_o1_ instanceof OnlineInfo)) { assign((OnlineInfo)_o1_);
/*   64 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   65 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   66 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(OnlineInfo _o_) {
/*   71 */     _o_._xdb_verify_unsafe_();
/*   72 */     this.lastcalcuatetime = _o_.lastcalcuatetime;
/*   73 */     this.single_online = _o_.single_online;
/*   74 */     this.is_adult = _o_.is_adult;
/*   75 */     this.accumu_time = _o_.accumu_time;
/*   76 */     this.age = _o_.age;
/*   77 */     this.report_count = _o_.report_count;
/*   78 */     this.period_time = _o_.period_time;
/*   79 */     this.kickout_type = _o_.kickout_type;
/*   80 */     this.rest_time = _o_.rest_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   85 */     this.lastcalcuatetime = _o_.lastcalcuatetime;
/*   86 */     this.single_online = _o_.single_online;
/*   87 */     this.is_adult = _o_.is_adult;
/*   88 */     this.accumu_time = _o_.accumu_time;
/*   89 */     this.age = _o_.age;
/*   90 */     this.report_count = _o_.report_count;
/*   91 */     this.period_time = _o_.period_time;
/*   92 */     this.kickout_type = _o_.kickout_type;
/*   93 */     this.rest_time = _o_.rest_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     _os_.marshal(this.lastcalcuatetime);
/*  101 */     _os_.marshal(this.single_online);
/*  102 */     _os_.marshal(this.is_adult);
/*  103 */     _os_.marshal(this.accumu_time);
/*  104 */     _os_.marshal(this.age);
/*  105 */     _os_.marshal(this.report_count);
/*  106 */     _os_.marshal(this.period_time);
/*  107 */     _os_.marshal(this.kickout_type);
/*  108 */     _os_.marshal(this.rest_time);
/*  109 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     this.lastcalcuatetime = _os_.unmarshal_long();
/*  117 */     this.single_online = _os_.unmarshal_int();
/*  118 */     this.is_adult = _os_.unmarshal_int();
/*  119 */     this.accumu_time = _os_.unmarshal_int();
/*  120 */     this.age = _os_.unmarshal_int();
/*  121 */     this.report_count = _os_.unmarshal_int();
/*  122 */     this.period_time = _os_.unmarshal_int();
/*  123 */     this.kickout_type = _os_.unmarshal_int();
/*  124 */     this.rest_time = _os_.unmarshal_int();
/*  125 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     int _size_ = 0;
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(1, this.lastcalcuatetime);
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(2, this.single_online);
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(4, this.is_adult);
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(5, this.accumu_time);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(6, this.age);
/*  138 */     _size_ += CodedOutputStream.computeInt32Size(7, this.report_count);
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(8, this.period_time);
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(9, this.kickout_type);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(10, this.rest_time);
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt64(1, this.lastcalcuatetime);
/*  152 */       _output_.writeInt32(2, this.single_online);
/*  153 */       _output_.writeInt32(4, this.is_adult);
/*  154 */       _output_.writeInt32(5, this.accumu_time);
/*  155 */       _output_.writeInt32(6, this.age);
/*  156 */       _output_.writeInt32(7, this.report_count);
/*  157 */       _output_.writeInt32(8, this.period_time);
/*  158 */       _output_.writeInt32(9, this.kickout_type);
/*  159 */       _output_.writeInt32(10, this.rest_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  165 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       boolean done = false;
/*  175 */       while (!done)
/*      */       {
/*  177 */         int tag = _input_.readTag();
/*  178 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  182 */           done = true;
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  187 */           this.lastcalcuatetime = _input_.readInt64();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  192 */           this.single_online = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  197 */           this.is_adult = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  202 */           this.accumu_time = _input_.readInt32();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  207 */           this.age = _input_.readInt32();
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  212 */           this.report_count = _input_.readInt32();
/*  213 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  217 */           this.period_time = _input_.readInt32();
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  222 */           this.kickout_type = _input_.readInt32();
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  227 */           this.rest_time = _input_.readInt32();
/*  228 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  232 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  234 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  243 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  247 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  249 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OnlineInfo copy()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new OnlineInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OnlineInfo toData()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.OnlineInfo toBean()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new OnlineInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OnlineInfo toDataIf()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.OnlineInfo toBeanIf()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastcalcuatetime()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this.lastcalcuatetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSingle_online()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this.single_online;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIs_adult()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.is_adult;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAccumu_time()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.accumu_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAge()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.age;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReport_count()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return this.report_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPeriod_time()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return this.period_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getKickout_type()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return this.kickout_type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRest_time()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.rest_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastcalcuatetime(long _v_)
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     Logs.logIf(new LogKey(this, "lastcalcuatetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  373 */         new LogLong(this, OnlineInfo.this.lastcalcuatetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  377 */             OnlineInfo.this.lastcalcuatetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  381 */     });
/*  382 */     this.lastcalcuatetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSingle_online(int _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     Logs.logIf(new LogKey(this, "single_online")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  394 */         new LogInt(this, OnlineInfo.this.single_online)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             OnlineInfo.this.single_online = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.single_online = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_adult(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     Logs.logIf(new LogKey(this, "is_adult")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  415 */         new LogInt(this, OnlineInfo.this.is_adult)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             OnlineInfo.this.is_adult = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.is_adult = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAccumu_time(int _v_)
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     Logs.logIf(new LogKey(this, "accumu_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  436 */         new LogInt(this, OnlineInfo.this.accumu_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  440 */             OnlineInfo.this.accumu_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  444 */     });
/*  445 */     this.accumu_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAge(int _v_)
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     Logs.logIf(new LogKey(this, "age")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  457 */         new LogInt(this, OnlineInfo.this.age)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  461 */             OnlineInfo.this.age = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  465 */     });
/*  466 */     this.age = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReport_count(int _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     Logs.logIf(new LogKey(this, "report_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  478 */         new LogInt(this, OnlineInfo.this.report_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  482 */             OnlineInfo.this.report_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  486 */     });
/*  487 */     this.report_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPeriod_time(int _v_)
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     Logs.logIf(new LogKey(this, "period_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  499 */         new LogInt(this, OnlineInfo.this.period_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  503 */             OnlineInfo.this.period_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  507 */     });
/*  508 */     this.period_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKickout_type(int _v_)
/*      */   {
/*  515 */     _xdb_verify_unsafe_();
/*  516 */     Logs.logIf(new LogKey(this, "kickout_type")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  520 */         new LogInt(this, OnlineInfo.this.kickout_type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  524 */             OnlineInfo.this.kickout_type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  528 */     });
/*  529 */     this.kickout_type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRest_time(int _v_)
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     Logs.logIf(new LogKey(this, "rest_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  541 */         new LogInt(this, OnlineInfo.this.rest_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  545 */             OnlineInfo.this.rest_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  549 */     });
/*  550 */     this.rest_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     OnlineInfo _o_ = null;
/*  558 */     if ((_o1_ instanceof OnlineInfo)) { _o_ = (OnlineInfo)_o1_;
/*  559 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  560 */       return false;
/*  561 */     if (this.lastcalcuatetime != _o_.lastcalcuatetime) return false;
/*  562 */     if (this.single_online != _o_.single_online) return false;
/*  563 */     if (this.is_adult != _o_.is_adult) return false;
/*  564 */     if (this.accumu_time != _o_.accumu_time) return false;
/*  565 */     if (this.age != _o_.age) return false;
/*  566 */     if (this.report_count != _o_.report_count) return false;
/*  567 */     if (this.period_time != _o_.period_time) return false;
/*  568 */     if (this.kickout_type != _o_.kickout_type) return false;
/*  569 */     if (this.rest_time != _o_.rest_time) return false;
/*  570 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  576 */     _xdb_verify_unsafe_();
/*  577 */     int _h_ = 0;
/*  578 */     _h_ = (int)(_h_ + this.lastcalcuatetime);
/*  579 */     _h_ += this.single_online;
/*  580 */     _h_ += this.is_adult;
/*  581 */     _h_ += this.accumu_time;
/*  582 */     _h_ += this.age;
/*  583 */     _h_ += this.report_count;
/*  584 */     _h_ += this.period_time;
/*  585 */     _h_ += this.kickout_type;
/*  586 */     _h_ += this.rest_time;
/*  587 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  593 */     _xdb_verify_unsafe_();
/*  594 */     StringBuilder _sb_ = new StringBuilder();
/*  595 */     _sb_.append("(");
/*  596 */     _sb_.append(this.lastcalcuatetime);
/*  597 */     _sb_.append(",");
/*  598 */     _sb_.append(this.single_online);
/*  599 */     _sb_.append(",");
/*  600 */     _sb_.append(this.is_adult);
/*  601 */     _sb_.append(",");
/*  602 */     _sb_.append(this.accumu_time);
/*  603 */     _sb_.append(",");
/*  604 */     _sb_.append(this.age);
/*  605 */     _sb_.append(",");
/*  606 */     _sb_.append(this.report_count);
/*  607 */     _sb_.append(",");
/*  608 */     _sb_.append(this.period_time);
/*  609 */     _sb_.append(",");
/*  610 */     _sb_.append(this.kickout_type);
/*  611 */     _sb_.append(",");
/*  612 */     _sb_.append(this.rest_time);
/*  613 */     _sb_.append(")");
/*  614 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  620 */     ListenableBean lb = new ListenableBean();
/*  621 */     lb.add(new ListenableChanged().setVarName("lastcalcuatetime"));
/*  622 */     lb.add(new ListenableChanged().setVarName("single_online"));
/*  623 */     lb.add(new ListenableChanged().setVarName("is_adult"));
/*  624 */     lb.add(new ListenableChanged().setVarName("accumu_time"));
/*  625 */     lb.add(new ListenableChanged().setVarName("age"));
/*  626 */     lb.add(new ListenableChanged().setVarName("report_count"));
/*  627 */     lb.add(new ListenableChanged().setVarName("period_time"));
/*  628 */     lb.add(new ListenableChanged().setVarName("kickout_type"));
/*  629 */     lb.add(new ListenableChanged().setVarName("rest_time"));
/*  630 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.OnlineInfo {
/*      */     private Const() {}
/*      */     
/*      */     OnlineInfo nThis() {
/*  637 */       return OnlineInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineInfo copy()
/*      */     {
/*  649 */       return OnlineInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineInfo toData()
/*      */     {
/*  655 */       return OnlineInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.OnlineInfo toBean()
/*      */     {
/*  660 */       return OnlineInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineInfo toDataIf()
/*      */     {
/*  666 */       return OnlineInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.OnlineInfo toBeanIf()
/*      */     {
/*  671 */       return OnlineInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastcalcuatetime()
/*      */     {
/*  678 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  679 */       return OnlineInfo.this.lastcalcuatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSingle_online()
/*      */     {
/*  686 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  687 */       return OnlineInfo.this.single_online;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIs_adult()
/*      */     {
/*  694 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  695 */       return OnlineInfo.this.is_adult;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAccumu_time()
/*      */     {
/*  702 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  703 */       return OnlineInfo.this.accumu_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAge()
/*      */     {
/*  710 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  711 */       return OnlineInfo.this.age;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReport_count()
/*      */     {
/*  718 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  719 */       return OnlineInfo.this.report_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeriod_time()
/*      */     {
/*  726 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  727 */       return OnlineInfo.this.period_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKickout_type()
/*      */     {
/*  734 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  735 */       return OnlineInfo.this.kickout_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRest_time()
/*      */     {
/*  742 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  743 */       return OnlineInfo.this.rest_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastcalcuatetime(long _v_)
/*      */     {
/*  750 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSingle_online(int _v_)
/*      */     {
/*  758 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  759 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_adult(int _v_)
/*      */     {
/*  766 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  767 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumu_time(int _v_)
/*      */     {
/*  774 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  775 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAge(int _v_)
/*      */     {
/*  782 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  783 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReport_count(int _v_)
/*      */     {
/*  790 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  791 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriod_time(int _v_)
/*      */     {
/*  798 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  799 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKickout_type(int _v_)
/*      */     {
/*  806 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  807 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRest_time(int _v_)
/*      */     {
/*  814 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  821 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  822 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  828 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  829 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  835 */       return OnlineInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  841 */       return OnlineInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  847 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  848 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  854 */       return OnlineInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  860 */       return OnlineInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  866 */       OnlineInfo.this._xdb_verify_unsafe_();
/*  867 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  873 */       return OnlineInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  879 */       return OnlineInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  885 */       return OnlineInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  891 */       return OnlineInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  897 */       return OnlineInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  903 */       return OnlineInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  909 */       return OnlineInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.OnlineInfo
/*      */   {
/*      */     private long lastcalcuatetime;
/*      */     
/*      */     private int single_online;
/*      */     
/*      */     private int is_adult;
/*      */     
/*      */     private int accumu_time;
/*      */     
/*      */     private int age;
/*      */     
/*      */     private int report_count;
/*      */     
/*      */     private int period_time;
/*      */     
/*      */     private int kickout_type;
/*      */     
/*      */     private int rest_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.OnlineInfo _o1_)
/*      */     {
/*  946 */       if ((_o1_ instanceof OnlineInfo)) { assign((OnlineInfo)_o1_);
/*  947 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  948 */       } else if ((_o1_ instanceof OnlineInfo.Const)) assign(((OnlineInfo.Const)_o1_).nThis()); else {
/*  949 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(OnlineInfo _o_) {
/*  954 */       this.lastcalcuatetime = _o_.lastcalcuatetime;
/*  955 */       this.single_online = _o_.single_online;
/*  956 */       this.is_adult = _o_.is_adult;
/*  957 */       this.accumu_time = _o_.accumu_time;
/*  958 */       this.age = _o_.age;
/*  959 */       this.report_count = _o_.report_count;
/*  960 */       this.period_time = _o_.period_time;
/*  961 */       this.kickout_type = _o_.kickout_type;
/*  962 */       this.rest_time = _o_.rest_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  967 */       this.lastcalcuatetime = _o_.lastcalcuatetime;
/*  968 */       this.single_online = _o_.single_online;
/*  969 */       this.is_adult = _o_.is_adult;
/*  970 */       this.accumu_time = _o_.accumu_time;
/*  971 */       this.age = _o_.age;
/*  972 */       this.report_count = _o_.report_count;
/*  973 */       this.period_time = _o_.period_time;
/*  974 */       this.kickout_type = _o_.kickout_type;
/*  975 */       this.rest_time = _o_.rest_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  981 */       _os_.marshal(this.lastcalcuatetime);
/*  982 */       _os_.marshal(this.single_online);
/*  983 */       _os_.marshal(this.is_adult);
/*  984 */       _os_.marshal(this.accumu_time);
/*  985 */       _os_.marshal(this.age);
/*  986 */       _os_.marshal(this.report_count);
/*  987 */       _os_.marshal(this.period_time);
/*  988 */       _os_.marshal(this.kickout_type);
/*  989 */       _os_.marshal(this.rest_time);
/*  990 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  996 */       this.lastcalcuatetime = _os_.unmarshal_long();
/*  997 */       this.single_online = _os_.unmarshal_int();
/*  998 */       this.is_adult = _os_.unmarshal_int();
/*  999 */       this.accumu_time = _os_.unmarshal_int();
/* 1000 */       this.age = _os_.unmarshal_int();
/* 1001 */       this.report_count = _os_.unmarshal_int();
/* 1002 */       this.period_time = _os_.unmarshal_int();
/* 1003 */       this.kickout_type = _os_.unmarshal_int();
/* 1004 */       this.rest_time = _os_.unmarshal_int();
/* 1005 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1011 */       int _size_ = 0;
/* 1012 */       _size_ += CodedOutputStream.computeInt64Size(1, this.lastcalcuatetime);
/* 1013 */       _size_ += CodedOutputStream.computeInt32Size(2, this.single_online);
/* 1014 */       _size_ += CodedOutputStream.computeInt32Size(4, this.is_adult);
/* 1015 */       _size_ += CodedOutputStream.computeInt32Size(5, this.accumu_time);
/* 1016 */       _size_ += CodedOutputStream.computeInt32Size(6, this.age);
/* 1017 */       _size_ += CodedOutputStream.computeInt32Size(7, this.report_count);
/* 1018 */       _size_ += CodedOutputStream.computeInt32Size(8, this.period_time);
/* 1019 */       _size_ += CodedOutputStream.computeInt32Size(9, this.kickout_type);
/* 1020 */       _size_ += CodedOutputStream.computeInt32Size(10, this.rest_time);
/* 1021 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1029 */         _output_.writeInt64(1, this.lastcalcuatetime);
/* 1030 */         _output_.writeInt32(2, this.single_online);
/* 1031 */         _output_.writeInt32(4, this.is_adult);
/* 1032 */         _output_.writeInt32(5, this.accumu_time);
/* 1033 */         _output_.writeInt32(6, this.age);
/* 1034 */         _output_.writeInt32(7, this.report_count);
/* 1035 */         _output_.writeInt32(8, this.period_time);
/* 1036 */         _output_.writeInt32(9, this.kickout_type);
/* 1037 */         _output_.writeInt32(10, this.rest_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1041 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1043 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1051 */         boolean done = false;
/* 1052 */         while (!done)
/*      */         {
/* 1054 */           int tag = _input_.readTag();
/* 1055 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1059 */             done = true;
/* 1060 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1064 */             this.lastcalcuatetime = _input_.readInt64();
/* 1065 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1069 */             this.single_online = _input_.readInt32();
/* 1070 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1074 */             this.is_adult = _input_.readInt32();
/* 1075 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1079 */             this.accumu_time = _input_.readInt32();
/* 1080 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1084 */             this.age = _input_.readInt32();
/* 1085 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1089 */             this.report_count = _input_.readInt32();
/* 1090 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1094 */             this.period_time = _input_.readInt32();
/* 1095 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1099 */             this.kickout_type = _input_.readInt32();
/* 1100 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1104 */             this.rest_time = _input_.readInt32();
/* 1105 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1109 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1111 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1120 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1124 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1126 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineInfo copy()
/*      */     {
/* 1132 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineInfo toData()
/*      */     {
/* 1138 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.OnlineInfo toBean()
/*      */     {
/* 1143 */       return new OnlineInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineInfo toDataIf()
/*      */     {
/* 1149 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.OnlineInfo toBeanIf()
/*      */     {
/* 1154 */       return new OnlineInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1160 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1164 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1168 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1176 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1180 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1184 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastcalcuatetime()
/*      */     {
/* 1191 */       return this.lastcalcuatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSingle_online()
/*      */     {
/* 1198 */       return this.single_online;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIs_adult()
/*      */     {
/* 1205 */       return this.is_adult;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAccumu_time()
/*      */     {
/* 1212 */       return this.accumu_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAge()
/*      */     {
/* 1219 */       return this.age;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReport_count()
/*      */     {
/* 1226 */       return this.report_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeriod_time()
/*      */     {
/* 1233 */       return this.period_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKickout_type()
/*      */     {
/* 1240 */       return this.kickout_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRest_time()
/*      */     {
/* 1247 */       return this.rest_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastcalcuatetime(long _v_)
/*      */     {
/* 1254 */       this.lastcalcuatetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSingle_online(int _v_)
/*      */     {
/* 1261 */       this.single_online = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_adult(int _v_)
/*      */     {
/* 1268 */       this.is_adult = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumu_time(int _v_)
/*      */     {
/* 1275 */       this.accumu_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAge(int _v_)
/*      */     {
/* 1282 */       this.age = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReport_count(int _v_)
/*      */     {
/* 1289 */       this.report_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriod_time(int _v_)
/*      */     {
/* 1296 */       this.period_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKickout_type(int _v_)
/*      */     {
/* 1303 */       this.kickout_type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRest_time(int _v_)
/*      */     {
/* 1310 */       this.rest_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1316 */       if (!(_o1_ instanceof Data)) return false;
/* 1317 */       Data _o_ = (Data)_o1_;
/* 1318 */       if (this.lastcalcuatetime != _o_.lastcalcuatetime) return false;
/* 1319 */       if (this.single_online != _o_.single_online) return false;
/* 1320 */       if (this.is_adult != _o_.is_adult) return false;
/* 1321 */       if (this.accumu_time != _o_.accumu_time) return false;
/* 1322 */       if (this.age != _o_.age) return false;
/* 1323 */       if (this.report_count != _o_.report_count) return false;
/* 1324 */       if (this.period_time != _o_.period_time) return false;
/* 1325 */       if (this.kickout_type != _o_.kickout_type) return false;
/* 1326 */       if (this.rest_time != _o_.rest_time) return false;
/* 1327 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1333 */       int _h_ = 0;
/* 1334 */       _h_ = (int)(_h_ + this.lastcalcuatetime);
/* 1335 */       _h_ += this.single_online;
/* 1336 */       _h_ += this.is_adult;
/* 1337 */       _h_ += this.accumu_time;
/* 1338 */       _h_ += this.age;
/* 1339 */       _h_ += this.report_count;
/* 1340 */       _h_ += this.period_time;
/* 1341 */       _h_ += this.kickout_type;
/* 1342 */       _h_ += this.rest_time;
/* 1343 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1349 */       StringBuilder _sb_ = new StringBuilder();
/* 1350 */       _sb_.append("(");
/* 1351 */       _sb_.append(this.lastcalcuatetime);
/* 1352 */       _sb_.append(",");
/* 1353 */       _sb_.append(this.single_online);
/* 1354 */       _sb_.append(",");
/* 1355 */       _sb_.append(this.is_adult);
/* 1356 */       _sb_.append(",");
/* 1357 */       _sb_.append(this.accumu_time);
/* 1358 */       _sb_.append(",");
/* 1359 */       _sb_.append(this.age);
/* 1360 */       _sb_.append(",");
/* 1361 */       _sb_.append(this.report_count);
/* 1362 */       _sb_.append(",");
/* 1363 */       _sb_.append(this.period_time);
/* 1364 */       _sb_.append(",");
/* 1365 */       _sb_.append(this.kickout_type);
/* 1366 */       _sb_.append(",");
/* 1367 */       _sb_.append(this.rest_time);
/* 1368 */       _sb_.append(")");
/* 1369 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\OnlineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */