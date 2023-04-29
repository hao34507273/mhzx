/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import mzm.gsp.memorycompetition.main.MemoryCompetitionPrepareObserver;
/*      */ import mzm.gsp.memorycompetition.main.MemoryCompetitionQuestionObserver;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import xbean.RolesMemoryQuestion;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class MemoryCompetitionInfo extends XBean implements xbean.MemoryCompetitionInfo
/*      */ {
/*      */   private HashMap<Integer, Integer> mapping;
/*      */   private ArrayList<Long> role_id_list;
/*      */   private int activity_cfg_id;
/*      */   private int memory_competition_cfg_id;
/*      */   private int current_round_num;
/*      */   private int current_score;
/*      */   private boolean is_need_notify_after_every_question;
/*      */   private MemoryCompetitionQuestionObserver roles_current_question_observer;
/*      */   private HashMap<Long, RolesMemoryQuestion> roles_answered_question_map;
/*      */   private HashMap<Long, Integer> roles_seek_help_times_map;
/*      */   private MemoryCompetitionPrepareObserver roles_current_prepare_question_observer;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.mapping.clear();
/*   39 */     this.role_id_list.clear();
/*   40 */     this.activity_cfg_id = 0;
/*   41 */     this.memory_competition_cfg_id = 0;
/*   42 */     this.current_round_num = 0;
/*   43 */     this.current_score = 0;
/*   44 */     this.is_need_notify_after_every_question = false;
/*   45 */     this.roles_current_question_observer = null;
/*   46 */     this.roles_answered_question_map.clear();
/*   47 */     this.roles_seek_help_times_map.clear();
/*   48 */     this.roles_current_prepare_question_observer = null;
/*      */   }
/*      */   
/*      */   MemoryCompetitionInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.mapping = new HashMap();
/*   55 */     this.role_id_list = new ArrayList();
/*   56 */     this.roles_current_question_observer = null;
/*   57 */     this.roles_answered_question_map = new HashMap();
/*   58 */     this.roles_seek_help_times_map = new HashMap();
/*   59 */     this.roles_current_prepare_question_observer = null;
/*      */   }
/*      */   
/*      */   public MemoryCompetitionInfo()
/*      */   {
/*   64 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MemoryCompetitionInfo(MemoryCompetitionInfo _o_)
/*      */   {
/*   69 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MemoryCompetitionInfo(xbean.MemoryCompetitionInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   74 */     super(_xp_, _vn_);
/*   75 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   81 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   87 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*   93 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws ppbio.InvalidProtocolBufferException
/*      */   {
/*   99 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws ppbio.InvalidProtocolBufferException
/*      */   {
/*  105 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MemoryCompetitionInfo copy()
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     return new MemoryCompetitionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MemoryCompetitionInfo toData()
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MemoryCompetitionInfo toBean()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     return new MemoryCompetitionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MemoryCompetitionInfo toDataIf()
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MemoryCompetitionInfo toBeanIf()
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*  138 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getMapping()
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*  153 */     return Logs.logMap(new LogKey(this, "mapping"), this.mapping);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getMappingAsData()
/*      */   {
/*  160 */     _xdb_verify_unsafe_();
/*      */     
/*  162 */     MemoryCompetitionInfo _o_ = this;
/*  163 */     Map<Integer, Integer> mapping = new HashMap();
/*  164 */     for (Map.Entry<Integer, Integer> _e_ : _o_.mapping.entrySet())
/*  165 */       mapping.put(_e_.getKey(), _e_.getValue());
/*  166 */     return mapping;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRole_id_list()
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*  174 */     return Logs.logList(new LogKey(this, "role_id_list"), this.role_id_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRole_id_listAsData()
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     
/*  182 */     MemoryCompetitionInfo _o_ = this;
/*  183 */     List<Long> role_id_list = new ArrayList();
/*  184 */     role_id_list.addAll(_o_.role_id_list);
/*  185 */     return role_id_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivity_cfg_id()
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*  193 */     return this.activity_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMemory_competition_cfg_id()
/*      */   {
/*  200 */     _xdb_verify_unsafe_();
/*  201 */     return this.memory_competition_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_round_num()
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*  209 */     return this.current_round_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_score()
/*      */   {
/*  216 */     _xdb_verify_unsafe_();
/*  217 */     return this.current_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_need_notify_after_every_question()
/*      */   {
/*  224 */     _xdb_verify_unsafe_();
/*  225 */     return this.is_need_notify_after_every_question;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public MemoryCompetitionQuestionObserver getRoles_current_question_observer()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return this.roles_current_question_observer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, RolesMemoryQuestion> getRoles_answered_question_map()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return Logs.logMap(new LogKey(this, "roles_answered_question_map"), this.roles_answered_question_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, RolesMemoryQuestion> getRoles_answered_question_mapAsData()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*      */     
/*  250 */     MemoryCompetitionInfo _o_ = this;
/*  251 */     Map<Long, RolesMemoryQuestion> roles_answered_question_map = new HashMap();
/*  252 */     for (Map.Entry<Long, RolesMemoryQuestion> _e_ : _o_.roles_answered_question_map.entrySet())
/*  253 */       roles_answered_question_map.put(_e_.getKey(), new RolesMemoryQuestion.Data((RolesMemoryQuestion)_e_.getValue()));
/*  254 */     return roles_answered_question_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRoles_seek_help_times_map()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return Logs.logMap(new LogKey(this, "roles_seek_help_times_map"), this.roles_seek_help_times_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRoles_seek_help_times_mapAsData()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*      */     
/*  271 */     MemoryCompetitionInfo _o_ = this;
/*  272 */     Map<Long, Integer> roles_seek_help_times_map = new HashMap();
/*  273 */     for (Map.Entry<Long, Integer> _e_ : _o_.roles_seek_help_times_map.entrySet())
/*  274 */       roles_seek_help_times_map.put(_e_.getKey(), _e_.getValue());
/*  275 */     return roles_seek_help_times_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public MemoryCompetitionPrepareObserver getRoles_current_prepare_question_observer()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this.roles_current_prepare_question_observer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivity_cfg_id(int _v_)
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     Logs.logIf(new LogKey(this, "activity_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  295 */         new LogInt(this, MemoryCompetitionInfo.this.activity_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  299 */             MemoryCompetitionInfo.this.activity_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  303 */     });
/*  304 */     this.activity_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMemory_competition_cfg_id(int _v_)
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     Logs.logIf(new LogKey(this, "memory_competition_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  316 */         new LogInt(this, MemoryCompetitionInfo.this.memory_competition_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  320 */             MemoryCompetitionInfo.this.memory_competition_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  324 */     });
/*  325 */     this.memory_competition_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_round_num(int _v_)
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     Logs.logIf(new LogKey(this, "current_round_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  337 */         new LogInt(this, MemoryCompetitionInfo.this.current_round_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  341 */             MemoryCompetitionInfo.this.current_round_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  345 */     });
/*  346 */     this.current_round_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_score(int _v_)
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     Logs.logIf(new LogKey(this, "current_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  358 */         new LogInt(this, MemoryCompetitionInfo.this.current_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  362 */             MemoryCompetitionInfo.this.current_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  366 */     });
/*  367 */     this.current_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_need_notify_after_every_question(boolean _v_)
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     Logs.logIf(new LogKey(this, "is_need_notify_after_every_question")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  379 */         new xdb.logs.LogObject(this, Boolean.valueOf(MemoryCompetitionInfo.this.is_need_notify_after_every_question))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  383 */             MemoryCompetitionInfo.this.is_need_notify_after_every_question = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  387 */     });
/*  388 */     this.is_need_notify_after_every_question = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoles_current_question_observer(MemoryCompetitionQuestionObserver _v_)
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     Logs.logIf(new LogKey(this, "roles_current_question_observer")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  400 */         new xdb.logs.LogObject(this, MemoryCompetitionInfo.this.roles_current_question_observer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  404 */             MemoryCompetitionInfo.this.roles_current_question_observer = ((MemoryCompetitionQuestionObserver)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  408 */     });
/*  409 */     this.roles_current_question_observer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoles_current_prepare_question_observer(MemoryCompetitionPrepareObserver _v_)
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     Logs.logIf(new LogKey(this, "roles_current_prepare_question_observer")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  421 */         new xdb.logs.LogObject(this, MemoryCompetitionInfo.this.roles_current_prepare_question_observer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  425 */             MemoryCompetitionInfo.this.roles_current_prepare_question_observer = ((MemoryCompetitionPrepareObserver)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  429 */     });
/*  430 */     this.roles_current_prepare_question_observer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     MemoryCompetitionInfo _o_ = null;
/*  438 */     if ((_o1_ instanceof MemoryCompetitionInfo)) { _o_ = (MemoryCompetitionInfo)_o1_;
/*  439 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  440 */       return false;
/*  441 */     if (!this.mapping.equals(_o_.mapping)) return false;
/*  442 */     if (!this.role_id_list.equals(_o_.role_id_list)) return false;
/*  443 */     if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  444 */     if (this.memory_competition_cfg_id != _o_.memory_competition_cfg_id) return false;
/*  445 */     if (this.current_round_num != _o_.current_round_num) return false;
/*  446 */     if (this.current_score != _o_.current_score) return false;
/*  447 */     if (this.is_need_notify_after_every_question != _o_.is_need_notify_after_every_question) return false;
/*  448 */     if (((null == this.roles_current_question_observer) && (null != _o_.roles_current_question_observer)) || ((null != this.roles_current_question_observer) && (null == _o_.roles_current_question_observer)) || ((null != this.roles_current_question_observer) && (null != _o_.roles_current_question_observer) && (!this.roles_current_question_observer.equals(_o_.roles_current_question_observer)))) return false;
/*  449 */     if (!this.roles_answered_question_map.equals(_o_.roles_answered_question_map)) return false;
/*  450 */     if (!this.roles_seek_help_times_map.equals(_o_.roles_seek_help_times_map)) return false;
/*  451 */     if (((null == this.roles_current_prepare_question_observer) && (null != _o_.roles_current_prepare_question_observer)) || ((null != this.roles_current_prepare_question_observer) && (null == _o_.roles_current_prepare_question_observer)) || ((null != this.roles_current_prepare_question_observer) && (null != _o_.roles_current_prepare_question_observer) && (!this.roles_current_prepare_question_observer.equals(_o_.roles_current_prepare_question_observer)))) return false;
/*  452 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     int _h_ = 0;
/*  460 */     _h_ += this.mapping.hashCode();
/*  461 */     _h_ += this.role_id_list.hashCode();
/*  462 */     _h_ += this.activity_cfg_id;
/*  463 */     _h_ += this.memory_competition_cfg_id;
/*  464 */     _h_ += this.current_round_num;
/*  465 */     _h_ += this.current_score;
/*  466 */     _h_ += (this.is_need_notify_after_every_question ? 1231 : 1237);
/*  467 */     _h_ += (this.roles_current_question_observer == null ? 0 : this.roles_current_question_observer.hashCode());
/*  468 */     _h_ += this.roles_answered_question_map.hashCode();
/*  469 */     _h_ += this.roles_seek_help_times_map.hashCode();
/*  470 */     _h_ += (this.roles_current_prepare_question_observer == null ? 0 : this.roles_current_prepare_question_observer.hashCode());
/*  471 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     StringBuilder _sb_ = new StringBuilder();
/*  479 */     _sb_.append("(");
/*  480 */     _sb_.append(this.mapping);
/*  481 */     _sb_.append(",");
/*  482 */     _sb_.append(this.role_id_list);
/*  483 */     _sb_.append(",");
/*  484 */     _sb_.append(this.activity_cfg_id);
/*  485 */     _sb_.append(",");
/*  486 */     _sb_.append(this.memory_competition_cfg_id);
/*  487 */     _sb_.append(",");
/*  488 */     _sb_.append(this.current_round_num);
/*  489 */     _sb_.append(",");
/*  490 */     _sb_.append(this.current_score);
/*  491 */     _sb_.append(",");
/*  492 */     _sb_.append(this.is_need_notify_after_every_question);
/*  493 */     _sb_.append(",");
/*  494 */     _sb_.append(this.roles_current_question_observer);
/*  495 */     _sb_.append(",");
/*  496 */     _sb_.append(this.roles_answered_question_map);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.roles_seek_help_times_map);
/*  499 */     _sb_.append(",");
/*  500 */     _sb_.append(this.roles_current_prepare_question_observer);
/*  501 */     _sb_.append(")");
/*  502 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  508 */     ListenableBean lb = new ListenableBean();
/*  509 */     lb.add(new xdb.logs.ListenableMap().setVarName("mapping"));
/*  510 */     lb.add(new ListenableChanged().setVarName("role_id_list"));
/*  511 */     lb.add(new ListenableChanged().setVarName("activity_cfg_id"));
/*  512 */     lb.add(new ListenableChanged().setVarName("memory_competition_cfg_id"));
/*  513 */     lb.add(new ListenableChanged().setVarName("current_round_num"));
/*  514 */     lb.add(new ListenableChanged().setVarName("current_score"));
/*  515 */     lb.add(new ListenableChanged().setVarName("is_need_notify_after_every_question"));
/*  516 */     lb.add(new ListenableChanged().setVarName("roles_current_question_observer"));
/*  517 */     lb.add(new xdb.logs.ListenableMap().setVarName("roles_answered_question_map"));
/*  518 */     lb.add(new xdb.logs.ListenableMap().setVarName("roles_seek_help_times_map"));
/*  519 */     lb.add(new ListenableChanged().setVarName("roles_current_prepare_question_observer"));
/*  520 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MemoryCompetitionInfo {
/*      */     private Const() {}
/*      */     
/*      */     MemoryCompetitionInfo nThis() {
/*  527 */       return MemoryCompetitionInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  533 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MemoryCompetitionInfo copy()
/*      */     {
/*  539 */       return MemoryCompetitionInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MemoryCompetitionInfo toData()
/*      */     {
/*  545 */       return MemoryCompetitionInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MemoryCompetitionInfo toBean()
/*      */     {
/*  550 */       return MemoryCompetitionInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MemoryCompetitionInfo toDataIf()
/*      */     {
/*  556 */       return MemoryCompetitionInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MemoryCompetitionInfo toBeanIf()
/*      */     {
/*  561 */       return MemoryCompetitionInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMapping()
/*      */     {
/*  568 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  569 */       return xdb.Consts.constMap(MemoryCompetitionInfo.this.mapping);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMappingAsData()
/*      */     {
/*  576 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  578 */       MemoryCompetitionInfo _o_ = MemoryCompetitionInfo.this;
/*  579 */       Map<Integer, Integer> mapping = new HashMap();
/*  580 */       for (Map.Entry<Integer, Integer> _e_ : _o_.mapping.entrySet())
/*  581 */         mapping.put(_e_.getKey(), _e_.getValue());
/*  582 */       return mapping;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRole_id_list()
/*      */     {
/*  589 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  590 */       return xdb.Consts.constList(MemoryCompetitionInfo.this.role_id_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRole_id_listAsData()
/*      */     {
/*  596 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  598 */       MemoryCompetitionInfo _o_ = MemoryCompetitionInfo.this;
/*  599 */       List<Long> role_id_list = new ArrayList();
/*  600 */       role_id_list.addAll(_o_.role_id_list);
/*  601 */       return role_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_cfg_id()
/*      */     {
/*  608 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  609 */       return MemoryCompetitionInfo.this.activity_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMemory_competition_cfg_id()
/*      */     {
/*  616 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  617 */       return MemoryCompetitionInfo.this.memory_competition_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_round_num()
/*      */     {
/*  624 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  625 */       return MemoryCompetitionInfo.this.current_round_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_score()
/*      */     {
/*  632 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  633 */       return MemoryCompetitionInfo.this.current_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_need_notify_after_every_question()
/*      */     {
/*  640 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  641 */       return MemoryCompetitionInfo.this.is_need_notify_after_every_question;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MemoryCompetitionQuestionObserver getRoles_current_question_observer()
/*      */     {
/*  648 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  649 */       return MemoryCompetitionInfo.this.roles_current_question_observer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, RolesMemoryQuestion> getRoles_answered_question_map()
/*      */     {
/*  656 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  657 */       return xdb.Consts.constMap(MemoryCompetitionInfo.this.roles_answered_question_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, RolesMemoryQuestion> getRoles_answered_question_mapAsData()
/*      */     {
/*  664 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  666 */       MemoryCompetitionInfo _o_ = MemoryCompetitionInfo.this;
/*  667 */       Map<Long, RolesMemoryQuestion> roles_answered_question_map = new HashMap();
/*  668 */       for (Map.Entry<Long, RolesMemoryQuestion> _e_ : _o_.roles_answered_question_map.entrySet())
/*  669 */         roles_answered_question_map.put(_e_.getKey(), new RolesMemoryQuestion.Data((RolesMemoryQuestion)_e_.getValue()));
/*  670 */       return roles_answered_question_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoles_seek_help_times_map()
/*      */     {
/*  677 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  678 */       return xdb.Consts.constMap(MemoryCompetitionInfo.this.roles_seek_help_times_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoles_seek_help_times_mapAsData()
/*      */     {
/*  685 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  687 */       MemoryCompetitionInfo _o_ = MemoryCompetitionInfo.this;
/*  688 */       Map<Long, Integer> roles_seek_help_times_map = new HashMap();
/*  689 */       for (Map.Entry<Long, Integer> _e_ : _o_.roles_seek_help_times_map.entrySet())
/*  690 */         roles_seek_help_times_map.put(_e_.getKey(), _e_.getValue());
/*  691 */       return roles_seek_help_times_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MemoryCompetitionPrepareObserver getRoles_current_prepare_question_observer()
/*      */     {
/*  698 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  699 */       return MemoryCompetitionInfo.this.roles_current_prepare_question_observer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_cfg_id(int _v_)
/*      */     {
/*  706 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMemory_competition_cfg_id(int _v_)
/*      */     {
/*  714 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_round_num(int _v_)
/*      */     {
/*  722 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  723 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_score(int _v_)
/*      */     {
/*  730 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  731 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_need_notify_after_every_question(boolean _v_)
/*      */     {
/*  738 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoles_current_question_observer(MemoryCompetitionQuestionObserver _v_)
/*      */     {
/*  746 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  747 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoles_current_prepare_question_observer(MemoryCompetitionPrepareObserver _v_)
/*      */     {
/*  754 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  755 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  761 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  762 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  768 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  769 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  775 */       return MemoryCompetitionInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  781 */       return MemoryCompetitionInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  787 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  788 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  794 */       return MemoryCompetitionInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws ppbio.InvalidProtocolBufferException
/*      */     {
/*  800 */       return MemoryCompetitionInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws ppbio.InvalidProtocolBufferException
/*      */     {
/*  806 */       MemoryCompetitionInfo.this._xdb_verify_unsafe_();
/*  807 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  813 */       return MemoryCompetitionInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  819 */       return MemoryCompetitionInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  825 */       return MemoryCompetitionInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  831 */       return MemoryCompetitionInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  837 */       return MemoryCompetitionInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  843 */       return MemoryCompetitionInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  849 */       return MemoryCompetitionInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MemoryCompetitionInfo
/*      */   {
/*      */     private HashMap<Integer, Integer> mapping;
/*      */     
/*      */     private ArrayList<Long> role_id_list;
/*      */     
/*      */     private int activity_cfg_id;
/*      */     
/*      */     private int memory_competition_cfg_id;
/*      */     
/*      */     private int current_round_num;
/*      */     
/*      */     private int current_score;
/*      */     
/*      */     private boolean is_need_notify_after_every_question;
/*      */     
/*      */     private MemoryCompetitionQuestionObserver roles_current_question_observer;
/*      */     
/*      */     private HashMap<Long, RolesMemoryQuestion> roles_answered_question_map;
/*      */     
/*      */     private HashMap<Long, Integer> roles_seek_help_times_map;
/*      */     
/*      */     private MemoryCompetitionPrepareObserver roles_current_prepare_question_observer;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  881 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  886 */       this.mapping = new HashMap();
/*  887 */       this.role_id_list = new ArrayList();
/*  888 */       this.roles_current_question_observer = null;
/*  889 */       this.roles_answered_question_map = new HashMap();
/*  890 */       this.roles_seek_help_times_map = new HashMap();
/*  891 */       this.roles_current_prepare_question_observer = null;
/*      */     }
/*      */     
/*      */     Data(xbean.MemoryCompetitionInfo _o1_)
/*      */     {
/*  896 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  902 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  908 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  914 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws ppbio.InvalidProtocolBufferException
/*      */     {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws ppbio.InvalidProtocolBufferException
/*      */     {
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MemoryCompetitionInfo copy()
/*      */     {
/*  932 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MemoryCompetitionInfo toData()
/*      */     {
/*  938 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MemoryCompetitionInfo toBean()
/*      */     {
/*  943 */       return new MemoryCompetitionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MemoryCompetitionInfo toDataIf()
/*      */     {
/*  949 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MemoryCompetitionInfo toBeanIf()
/*      */     {
/*  954 */       return new MemoryCompetitionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  960 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  964 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  980 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  984 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMapping()
/*      */     {
/*  991 */       return this.mapping;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMappingAsData()
/*      */     {
/*  998 */       return this.mapping;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRole_id_list()
/*      */     {
/* 1005 */       return this.role_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRole_id_listAsData()
/*      */     {
/* 1012 */       return this.role_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_cfg_id()
/*      */     {
/* 1019 */       return this.activity_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMemory_competition_cfg_id()
/*      */     {
/* 1026 */       return this.memory_competition_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_round_num()
/*      */     {
/* 1033 */       return this.current_round_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_score()
/*      */     {
/* 1040 */       return this.current_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_need_notify_after_every_question()
/*      */     {
/* 1047 */       return this.is_need_notify_after_every_question;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MemoryCompetitionQuestionObserver getRoles_current_question_observer()
/*      */     {
/* 1054 */       return this.roles_current_question_observer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, RolesMemoryQuestion> getRoles_answered_question_map()
/*      */     {
/* 1061 */       return this.roles_answered_question_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, RolesMemoryQuestion> getRoles_answered_question_mapAsData()
/*      */     {
/* 1068 */       return this.roles_answered_question_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoles_seek_help_times_map()
/*      */     {
/* 1075 */       return this.roles_seek_help_times_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRoles_seek_help_times_mapAsData()
/*      */     {
/* 1082 */       return this.roles_seek_help_times_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MemoryCompetitionPrepareObserver getRoles_current_prepare_question_observer()
/*      */     {
/* 1089 */       return this.roles_current_prepare_question_observer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_cfg_id(int _v_)
/*      */     {
/* 1096 */       this.activity_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMemory_competition_cfg_id(int _v_)
/*      */     {
/* 1103 */       this.memory_competition_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_round_num(int _v_)
/*      */     {
/* 1110 */       this.current_round_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_score(int _v_)
/*      */     {
/* 1117 */       this.current_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_need_notify_after_every_question(boolean _v_)
/*      */     {
/* 1124 */       this.is_need_notify_after_every_question = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoles_current_question_observer(MemoryCompetitionQuestionObserver _v_)
/*      */     {
/* 1131 */       this.roles_current_question_observer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoles_current_prepare_question_observer(MemoryCompetitionPrepareObserver _v_)
/*      */     {
/* 1138 */       this.roles_current_prepare_question_observer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1144 */       if (!(_o1_ instanceof Data)) return false;
/* 1145 */       Data _o_ = (Data)_o1_;
/* 1146 */       if (!this.mapping.equals(_o_.mapping)) return false;
/* 1147 */       if (!this.role_id_list.equals(_o_.role_id_list)) return false;
/* 1148 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 1149 */       if (this.memory_competition_cfg_id != _o_.memory_competition_cfg_id) return false;
/* 1150 */       if (this.current_round_num != _o_.current_round_num) return false;
/* 1151 */       if (this.current_score != _o_.current_score) return false;
/* 1152 */       if (this.is_need_notify_after_every_question != _o_.is_need_notify_after_every_question) return false;
/* 1153 */       if (((null == this.roles_current_question_observer) && (null != _o_.roles_current_question_observer)) || ((null != this.roles_current_question_observer) && (null == _o_.roles_current_question_observer)) || ((null != this.roles_current_question_observer) && (null != _o_.roles_current_question_observer) && (!this.roles_current_question_observer.equals(_o_.roles_current_question_observer)))) return false;
/* 1154 */       if (!this.roles_answered_question_map.equals(_o_.roles_answered_question_map)) return false;
/* 1155 */       if (!this.roles_seek_help_times_map.equals(_o_.roles_seek_help_times_map)) return false;
/* 1156 */       if (((null == this.roles_current_prepare_question_observer) && (null != _o_.roles_current_prepare_question_observer)) || ((null != this.roles_current_prepare_question_observer) && (null == _o_.roles_current_prepare_question_observer)) || ((null != this.roles_current_prepare_question_observer) && (null != _o_.roles_current_prepare_question_observer) && (!this.roles_current_prepare_question_observer.equals(_o_.roles_current_prepare_question_observer)))) return false;
/* 1157 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1163 */       int _h_ = 0;
/* 1164 */       _h_ += this.mapping.hashCode();
/* 1165 */       _h_ += this.role_id_list.hashCode();
/* 1166 */       _h_ += this.activity_cfg_id;
/* 1167 */       _h_ += this.memory_competition_cfg_id;
/* 1168 */       _h_ += this.current_round_num;
/* 1169 */       _h_ += this.current_score;
/* 1170 */       _h_ += (this.is_need_notify_after_every_question ? 1231 : 1237);
/* 1171 */       _h_ += (this.roles_current_question_observer == null ? 0 : this.roles_current_question_observer.hashCode());
/* 1172 */       _h_ += this.roles_answered_question_map.hashCode();
/* 1173 */       _h_ += this.roles_seek_help_times_map.hashCode();
/* 1174 */       _h_ += (this.roles_current_prepare_question_observer == null ? 0 : this.roles_current_prepare_question_observer.hashCode());
/* 1175 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1181 */       StringBuilder _sb_ = new StringBuilder();
/* 1182 */       _sb_.append("(");
/* 1183 */       _sb_.append(this.mapping);
/* 1184 */       _sb_.append(",");
/* 1185 */       _sb_.append(this.role_id_list);
/* 1186 */       _sb_.append(",");
/* 1187 */       _sb_.append(this.activity_cfg_id);
/* 1188 */       _sb_.append(",");
/* 1189 */       _sb_.append(this.memory_competition_cfg_id);
/* 1190 */       _sb_.append(",");
/* 1191 */       _sb_.append(this.current_round_num);
/* 1192 */       _sb_.append(",");
/* 1193 */       _sb_.append(this.current_score);
/* 1194 */       _sb_.append(",");
/* 1195 */       _sb_.append(this.is_need_notify_after_every_question);
/* 1196 */       _sb_.append(",");
/* 1197 */       _sb_.append(this.roles_current_question_observer);
/* 1198 */       _sb_.append(",");
/* 1199 */       _sb_.append(this.roles_answered_question_map);
/* 1200 */       _sb_.append(",");
/* 1201 */       _sb_.append(this.roles_seek_help_times_map);
/* 1202 */       _sb_.append(",");
/* 1203 */       _sb_.append(this.roles_current_prepare_question_observer);
/* 1204 */       _sb_.append(")");
/* 1205 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MemoryCompetitionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */